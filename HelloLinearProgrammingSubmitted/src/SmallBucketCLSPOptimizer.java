import gurobi.*; // importing gurobi package

public class SmallBucketCLSPOptimizer { // programmer-defined class

    public SmallBucketCLSPSolution optimize(int T, int nProducts, double c, double[] h, //
            double[] s, double[] I0, double[][] demand, double[] ts, double[] tp) { //
        // method to optimize the CLSP problem and return the solution object

        assert (0 < nProducts); // assert for number of products

        SmallBucketCLSPSolution result = new SmallBucketCLSPSolution(nProducts, T);
        // create a object for the solution of the CLSP problem

        try {

            // 1. create environment, model and set name
            // ------------------------------------------------------------------------

            GRBEnv env = new GRBEnv(); // new Gurobi environment
            env.set(GRB.IntParam.OutputFlag, 0); // to hide the detailed output

            GRBModel model = new GRBModel(env); // new Gurobi model
            model.set(GRB.StringAttr.ModelName, "Hello-Linear-Programming"); // model name

            // 2. define decision variables
            // -----------------------------------------------------------------------------------

            GRBVar[][] q = new GRBVar[nProducts][T]; // q=number of items produced in time period T
            GRBVar[][] y = new GRBVar[nProducts][T]; // boolean, whether product k is produced at
                                                     // time period t
            GRBVar[][] z = new GRBVar[nProducts][T]; // boolean, indicates if we start producing
                                                     // k at time period t
            GRBVar[][] I = new GRBVar[nProducts][T]; // inventory of product k

            for (int k = 0; k < nProducts; k++) {
                for (int t = 0; t < T; t++) {

                    // Decision variables
                    q[k][t] = model.addVar(0.0, GRB.INFINITY, 0.0, GRB.INTEGER, //
                            "Items produced of product" + Integer.toString(k) + "at" + //
                                    " time period" + Integer.toString(t)); //
                    y[k][t] = model.addVar(0.0, 1.0, 0.0, GRB.BINARY, // upper limit = 1 and binary
                            "Product " + Integer.toString(nProducts) + "produced at time period" //
                                    + Integer.toString(t)); //
                    z[k][t] = model.addVar(0.0, 1.0, 0.0, GRB.BINARY, // upper limit = 1 and binary
                            "Product" + Integer.toString(nProducts) + "at time period" //
                                    + Integer.toString(t)); //
                    I[k][t] = model.addVar(0.0, GRB.INFINITY, 0.0, GRB.INTEGER, // Only integer
                            "Inventory of product" + Integer.toString(k) + "at time period" //
                                    + Integer.toString(t)); // values allowed

                } // for
            } // for

            model.update(); // update model

            // 3. add constraints
            // -----------------------------------------------------------------------------------------------

            // inventory balance equations

            for (int k = 0; k < nProducts; k++) { // loop over products

                for (int t = 0; t < T; t++) { // loop over time periods

                    GRBLinExpr leftHandSide = new GRBLinExpr(); // lhs linear expression
                    GRBLinExpr rightHandSide = new GRBLinExpr(); // rhs linear expression

                    leftHandSide.addTerm(1.0, I[k][t]); // add term to lhs

                    if (t == 0) { // if time is 0
                        rightHandSide.addConstant(I0[k]); // add initial inventory
                    }

                    if (t > 0) { // to avoid negative time
                        rightHandSide.addTerm(1.0, I[k][t - 1]);
                    }
                    rightHandSide.addTerm(1.0, q[k][t]); // inventory balance equation
                    rightHandSide.addConstant(-1.0 * demand[k][t]); // inventory balance equation

                    model.addConstr(leftHandSide, GRB.EQUAL, rightHandSide, // add constraint
                            "constraint-inventory-balance-" + (k + 1) + "-" + (t + 1)); //

                } // for

            } // for

            // one product per time period
            // Constraint 16 of Problem 2.1

            for (int t = 0; t < T; t++) { // loop over time periods
                GRBLinExpr lhs = new GRBLinExpr(); // new lhs per time period
                for (int k = 0; k < nProducts; k++) { // loop over products

                    lhs.addTerm(1.0, y[k][t]); // for products per each time period

                }
                model.addConstr(lhs, GRB.LESS_EQUAL, 1.0, "production boolean for time period " //

                        + Integer.toString(t)); // add constraint for each time period
            }

            // setup decision / capacity constraint
            // Constraint 17 of Problem 2.1

            for (int k = 0; k < nProducts; k++) { // loop over products
                for (int t = 0; t < T; t++) { // loop over time periods
                    GRBLinExpr lhs = new GRBLinExpr(); // Left Hand Side
                    GRBLinExpr rhs = new GRBLinExpr(); // Right Hand Side
                    lhs.addTerm(ts[k], z[k][t]); // if product is produced for the first time
                    // include setup cost
                    lhs.addTerm(tp[k], q[k][t]); // production cost per product * items to produce
                    rhs.addTerm(c, y[k][t]); // full capacity
                    model.addConstr(lhs, GRB.EQUAL, rhs, "constraint for product" + // add constr.
                            Integer.toString(k) + " for time period " + Integer.toString(t)); //
                }
            }

            // setup carry-over over
            // Constraint 18 of Problem 2.1

            for (int k = 0; k < nProducts; k++) { // loop over products
                for (int t = 0; t < T; t++) { // loop over time periods

                    GRBLinExpr lhs = new GRBLinExpr(); // New Left hand side
                    GRBLinExpr rhs = new GRBLinExpr(); // New Right hand side

                    lhs.addTerm(1, y[k][t]); // if product is to be produced
                    if (t != 0) { // if time is not 0 then add the term below
                        lhs.addTerm(-1, y[k][t - 1]); // if it was produced in the last period
                    }
                    rhs.addTerm(1, z[k][t]); // sum of lhs should be lesser than 1

                    model.addConstr(lhs, GRB.LESS_EQUAL, rhs, "Constraint for carry over" + //
                            Integer.toString(k)); // add constraint
                }

            }

            // setup or carry-over
            // Constraint 18 of Problem 2.1
            for (int k = 0; k < nProducts; k++) { // loop over products
                for (int t = 0; t < T; t++) { // loop over time periods

                    GRBLinExpr lhs = new GRBLinExpr();
                    GRBLinExpr rhs = new GRBLinExpr();
                    if (t != 0) {
                        lhs.addTerm(1, y[k][t - 1]); // add if t is not 0
                    }
                    lhs.addTerm(1, z[k][t]);
                    rhs.addConstant(1); // rhs is equal to 1, 1.0 can be written in model
                    // constraint as well

                    model.addConstr(lhs, GRB.LESS_EQUAL, rhs, "Constraint for product" + // add
                    // constraint to the model
                            Integer.toString(k) + " for time period " + Integer.toString(t)); //
                }

            }
            // 4. define objective function

            // Objective function

            GRBLinExpr obj = new GRBLinExpr(); // new linear expression
            for (int t = 0; t < T; t++) { // loop over time periods
                for (int k = 0; k < nProducts; k++) { // loop over products

                    obj.addTerm(h[k], I[k][t]); // implement objective function
                    obj.addTerm(s[k], z[k][t]); // implement objective function
                }

            }
            model.setObjective(obj, GRB.MINIMIZE); // set objective, minimize objective function

            // 5. optimize
            // ------------------------------------------------------------------------------------------------------

            model.optimize(); // optimize model

            if (model.get(GRB.IntAttr.Status) == GRB.Status.OPTIMAL) { // if optimal
                result.setOptimalValue(model.get(GRB.DoubleAttr.ObjVal)); // send optimal value
                // to result object of SmallBucketCLSPSolution ( setOptimalValue )
                System.out.println("Optimization Status: " + model.get(GRB.IntAttr.Status));
                // prints optimization status ( 2 for optimal)
                for (int k = 0; k < nProducts; k++) { // loop over products
                    for (int t = 0; t < T; t++) { // loop over time periods

                        result.setQ(k, t, q[k][t].get(GRB.DoubleAttr.X)); // set prod. quantity
                        result.setY(k, t, y[k][t].get(GRB.DoubleAttr.X)); // set y boolean
                        result.setZ(k, t, z[k][t].get(GRB.DoubleAttr.X)); // set z boolean
                        result.setI(k, t, I[k][t].get(GRB.DoubleAttr.X)); // set Inventory values
                    }
                }

            } else { // If no optimal value

                System.out.println("No optimal solution found");

                model.computeIIS(); // compute Irreducible Inconsistent Subsystems (IIS)

                GRBConstr[] constraints = model.getConstrs(); // Constraints array, get all constr.

                for (int i = 0; i < constraints.length; i++) { // loop over constraints

                    GRBConstr constraint = constraints[i];

                    if (constraint.get(GRB.IntAttr.IISConstr) > 0) { // get constraint cannot
                        // be satisfied
                        System.out.println(constraint.get(GRB.StringAttr.ConstrName));
                    } // if

                } // for

                if (model.get(GRB.IntAttr.Status) == GRB.Status.UNBOUNDED) { // if model is
                    // unbounded
                    System.out.println("The model is unbouned and cannot be solved");
                }

                else {
                    System.out.println("Non-optimal solution, Optimization Status: " + //
                            model.get(GRB.IntAttr.Status)); // if none of the above,
                    // print optimization status
                }

                result.setOptimalValue(-1); // set optimal value to -1 if no optimal solution

            } // eif

            // clean up
            // ----------------------------------------------------------------------------

            model.dispose(); // dispose model
            env.dispose(); // dispose environment

        } catch (GRBException e) { // catch any exception

            e.printStackTrace(); // prints error stack trace

        } // catch me if you can

        return result; // return result object

    } // optimizer

}
