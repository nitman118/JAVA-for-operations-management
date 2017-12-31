import gurobi.*; //import Gurobi package

public class HelloLPOptimizer { // programmer-defined class

    public HelloLPSolution optimize(int nPlants, int nProducts, Plant[] plants, // class method
            double[] profitPerProduct) { // returns an object of HelloLPSolution class
        // pre : 0 < nProducts, #profitPerProduct = nProducts
        // ret : solution object with optimal value of LP shown in lecture

        assert (0 < nProducts); // assert 1
        assert (profitPerProduct.length == nProducts); // assert 2

        HelloLPSolution result = new HelloLPSolution(nPlants, nProducts); // create new object

        try {

            // 1. create environment, model and set name
            // ------------------------------------------------------------------------

            GRBEnv env = new GRBEnv(); // create new Gurobi Environment
            env.set(GRB.IntParam.OutputFlag, 0); // disables detailed output

            GRBModel model = new GRBModel(env); // create new LP model
            model.set(GRB.StringAttr.ModelName, "Hello-Linear-Programming"); // set name to model

            // 2. define decision variables
            // -------------------------------------------------------------------------------------

            GRBVar[] x = new GRBVar[nProducts]; // array definition for 3 decision variables

            for (int i = 0; i < nProducts; i++) { // loop to create 3 decision variables
                x[i] = model.addVar(0.0, GRB.INFINITY, 0.0, GRB.CONTINUOUS, "x" + // 0.0 is
                        Integer.toString(i)); // arbitrary coefficient of objective function
                // note that the lower bound of 0.0 automatically includes non-negative
                // constraint
            } // for

            model.update(); // model should be updated after decision variable definition

            // 3. add constraints
            // -----------------------------------------------------------------------------------------------

            GRBLinExpr c1_lhs = new GRBLinExpr(); // new Gurobi Linear expression
            for (int pl = 0; pl < nPlants; pl++) {
                for (int pr = 0; pr < nProducts; pr++) {
                    c1_lhs.addTerm(plants[pl].getProductionTimePerBatch(pr), x[pr]); // loops
                    // 3 times to create 3 constraints

                } // for

                model.addConstr(c1_lhs, GRB.LESS_EQUAL, plants[pl].getAvailableProductionTime(), //
                        "constraint-" + Integer.valueOf(pl)); // add constraint to model
                c1_lhs = new GRBLinExpr(); // re-initialize constraint

            } // for
              // 4. define objective function

            GRBLinExpr obj = new GRBLinExpr(); // nnew Gurobi Linear Expression

            for (int pr = 0; pr < nProducts; pr++) {
                obj.addTerm(profitPerProduct[pr], x[pr]); // loops twice to complete obj. func.
            } // for

            model.setObjective(obj, GRB.MAXIMIZE); // set objective(to maximize) to the model

            // 5. optimize
            // ------------------------------------------------------------------------------------------------------

            model.optimize(); // call optimize method

            if (model.get(GRB.IntAttr.Status) == GRB.Status.OPTIMAL) { // check for optimality

                result.setOptimalValue(model.get(GRB.DoubleAttr.ObjVal)); // pass optimized
                // (maximized) value of objective function to result object

                for (int pr = 0; pr < nProducts; pr++) { // assign optimal batch quantity
                    // to batches in solution

                    result.setBatchQuantity(pr, x[pr].get(GRB.DoubleAttr.X)); // calls optimal
                    // value of decision variables
                } // for

                result.setSolutionCount(model.get(GRB.IntAttr.SolCount)); // assigns
                // solution count

                for (int i = 0; i < nPlants; i++) { // to calculate shadow pricing and
                    // allowable range - for exercise 1

                    GRBConstr c = model.getConstrByName("constraint-" + Integer.toString(i));
                    System.out.println("Shadow price constraint-" + i + ": " + c.get(GRB.DoubleAttr.Pi)); // this line
                    // calculates effect of having a unit change in our RHS in constraint(capacity)
                    // allowable lower range for rhs (capacity)
                    System.out.println("Allowable lower range: " + c.get(GRB.DoubleAttr.SARHSLow));
                    // allowable upper range for rhs (capacity)
                    System.out.println("Allowable upper range: " + c.get(GRB.DoubleAttr.SARHSUp));
                    System.out.println("\n");

                }

            } else {

                System.out.println("No optimal solution found"); // if solution is not optimal

                result.setOptimalValue(-1);

            } // eif

            // clean up
            // ---------------------------------------------------------------------------------------------------------

            model.dispose(); // dispose model
            env.dispose(); // dispose environment

        } catch (GRBException e) { // catch Gurobi Exception

            e.printStackTrace(); // print error stack trace

        } // catch me if you can

        return result; // return result object of HelloLPSolution

    } // optimizer

} // HelloLPOptimizer
