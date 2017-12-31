import gurobi.*;

public class SmallBucketCLSPOptimizer1 {

    public SmallBucketCLSPSolution optimize(int T, int nProducts, double c, double[] h, double[] s, double[] I0,
            double[][] demand, double[] ts, double[] tp) {
        // pre : 0 < nProducts, #profitPerProduct = nProducts
        // ret : solution object with optimal value of LP shown in lecture

        assert (0 < nProducts);

        SmallBucketCLSPSolution result = new SmallBucketCLSPSolution(nProducts, T);

        try {

            // 1. create environment, model and set name
            // ------------------------------------------------------------------------

            GRBEnv env = new GRBEnv();
            env.set(GRB.IntParam.OutputFlag, 0);

            GRBModel model = new GRBModel(env);
            model.set(GRB.StringAttr.ModelName, "Hello-Linear-Programming");

            // 2. define decision variables
            // -------------------------------------------------------------------------------------

            GRBVar[][] q = new GRBVar[nProducts][T];
            GRBVar[][] y = new GRBVar[nProducts][T];
            GRBVar[][] z = new GRBVar[nProducts][T];

            GRBVar[][] I = new GRBVar[nProducts][T];

            for (int k = 0; k < nProducts; k++) {
                for (int t = 0; t < T; t++) {
                    q[k][t] = model.addVar(0, GRB.INFINITY, 0, GRB.INTEGER,
                            "q" + Integer.toString(k) + "-" + Integer.toString(t));
                    y[k][t] = model.addVar(0.0, 1.0, 0.0, GRB.INTEGER,
                            "y" + Integer.toString(k) + "-" + Integer.toString(t));
                    z[k][t] = model.addVar(0.0, 1.0, 0.0, GRB.INTEGER,
                            "z" + Integer.toString(k) + "-" + Integer.toString(t));
                    I[k][t] = model.addVar(0, GRB.INFINITY, 0, GRB.INTEGER,
                            "I" + Integer.toString(k) + "-" + Integer.toString(t));
                    ;
                } // for
            } // for

            model.update();

            // 3. add constraints
            // -----------------------------------------------------------------------------------------------

            // inventory balance equations

            for (int k = 0; k < nProducts; k++) {

                for (int t = 0; t < T; t++) {

                    GRBLinExpr leftHandSide = new GRBLinExpr();
                    GRBLinExpr rightHandSide = new GRBLinExpr();

                    leftHandSide.addTerm(1.0, I[k][t]);

                    if (t == 0) {
                        rightHandSide.addConstant(I0[k]);
                    }

                    if (t > 0) {
                        rightHandSide.addTerm(1.0, I[k][t - 1]);
                    }
                    rightHandSide.addTerm(1.0, q[k][t]);
                    rightHandSide.addConstant(-1.0 * demand[k][t]);

                    model.addConstr(leftHandSide, GRB.EQUAL, rightHandSide,
                            "constraint-inventory-balance-" + (k + 1) + "-" + (t + 1));

                } // for

            } // for

            // one product per time period
            // Constraint 16 of Problem 2.1
            for (int t = 0; t < T; t++) {

                GRBLinExpr leftHandSide = new GRBLinExpr();
                GRBLinExpr rightHandSide = new GRBLinExpr();

                for (int k = 0; k < nProducts; k++) {
                    leftHandSide.addTerm(1.0, y[k][t]);
                }
                rightHandSide.addConstant(1.0);
                model.addConstr(leftHandSide, GRB.LESS_EQUAL, rightHandSide,
                        "constraint-one product per tp-" + (t + 1));

            }

            // setup decision / capacity constraint
            // Constraint 17 of Problem 2.1
            for (int k = 0; k < nProducts; k++) {

                for (int t = 0; t < T; t++) {

                    GRBLinExpr leftHandSide = new GRBLinExpr();
                    GRBLinExpr rightHandSide = new GRBLinExpr();

                    
                        leftHandSide.addTerm(ts[k], z[k][t]);
                        leftHandSide.addTerm(tp[k], q[k][t]);
                       rightHandSide.addTerm(c, y[k][t]);

                    model.addConstr(leftHandSide, GRB.EQUAL, rightHandSide,
                            "constraint-capacity-" + (k + 1) + "-" + (t + 1));
                }
            }

            // setup carry-over over
            // Constraint 18 of Problem 2.1
            for (int k = 0; k < nProducts; k++) {

                for (int t = 0; t < T; t++) {

                    GRBLinExpr leftHandSide = new GRBLinExpr();
                    GRBLinExpr rightHandSide = new GRBLinExpr();

                    leftHandSide.addTerm(1.0, y[k][t]);

                    if (t > 0) {
                        leftHandSide.addTerm(-1.0, y[k][t - 1]);
                    }

                    rightHandSide.addTerm(1, z[k][t]);

                    model.addConstr(leftHandSide, GRB.LESS_EQUAL, rightHandSide,
                            "constraint-setup/carry over-" + (k + 1) + "-" + (t + 1));
                }
            }

            // setup or carry-over
            // Constraint 19 of Problem 2.1
            for (int k = 0; k < nProducts; k++) {

                for (int t = 0; t < T; t++) {

                    GRBLinExpr leftHandSide = new GRBLinExpr();
                    GRBLinExpr rightHandSide = new GRBLinExpr();

                    if (t > 0) {
                        leftHandSide.addTerm(1.0, y[k][t - 1]);
                    }

                    leftHandSide.addTerm(1.0, z[k][t]);
                    rightHandSide.addConstant(1.0);

                    model.addConstr(leftHandSide, GRB.LESS_EQUAL, rightHandSide,
                            "constraint-carry over/setup-" + (k + 1) + "-" + (t + 1));
                }
            }

            // 4. define objective function
            // objective function
            GRBLinExpr obj = new GRBLinExpr();

            for (int k = 0; k < nProducts; k++) {

                for (int t = 0; t < T; t++) {

                    obj.addTerm(h[k], I[k][t]);
                    obj.addTerm(s[k], z[k][t]);
                }
            }
            model.setObjective(obj, GRB.MINIMIZE);

            // 5. optimize
            // ------------------------------------------------------------------------------------------------------

            model.optimize();

            if (model.get(GRB.IntAttr.Status) == GRB.Status.OPTIMAL) {

                // TODO implement
                result.setOptimalValue(model.get(GRB.DoubleAttr.ObjVal));

            } else {

                System.out.println("No optimal solution found");

                model.computeIIS();

                GRBConstr[] constraints = model.getConstrs();

                for (int i = 0; i < constraints.length; i++) {

                    GRBConstr constraint = constraints[i];

                    if (constraint.get(GRB.IntAttr.IISConstr) > 0) {
                        System.out.println(constraint.get(GRB.StringAttr.ConstrName));
                    } // if

                } // for

                result.setOptimalValue(-1);

            } // eif

            // clean up
            // ---------------------------------------------------------------------------------------------------------

            model.dispose();
            env.dispose();

        } catch (

        GRBException e) {

            e.printStackTrace();

        } // catch me if you can

        return result;

    } // optimizer

}
