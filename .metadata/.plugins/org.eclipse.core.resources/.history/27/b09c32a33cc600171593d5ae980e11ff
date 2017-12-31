public class ManagementDecisions {

    // hard-coded answers to questions in assignment

    // plant to extend capacity of
    private final int q1 = 2; // PLANT 2

    // shadow price of this plant
    private final int q2 = 3280; // A UNIT INCREASE IN CAPACITY LEADS TO AN INCREASE OF 3280 PROFIT

    // maximum value of allowable range of this plant
    private final int q3 = 15; // AS DETERMINED BY SARHSUp

    public int getQ1() {
        return this.q1;
    } // getQ1

    public int getQ2() {
        return this.q2;
    } // getQ2

    public int getQ3() {
        return this.q3;
    } // getQ3

    // for personal reference, can be ignored-----
    public static void main(String[] args) {

        int nPlants = 3;
        int nProducts = 2;

        Plant p1 = new Plant(nProducts, 4.0);
        Plant p2 = new Plant(nProducts, 12.0);
        Plant p3 = new Plant(nProducts, 18.0);

        p1.setProductionTimePerBatch(0, 1);
        p2.setProductionTimePerBatch(1, 1.25);
        p3.setProductionTimePerBatch(0, 2.5);
        p3.setProductionTimePerBatch(1, 1.5);

        double[] profitPerProduct = new double[] { 6500, 8000 };

        Plant[] plants = new Plant[] { p1, p2, p3 };

        HelloLPOptimizer opt = new HelloLPOptimizer();
        HelloLPSolution sol = opt.optimize(nPlants, nProducts, plants, profitPerProduct);

        System.out.println(sol.getOptimalValue());
        for (int i = 0; i < nProducts; i++) {
            System.out.println(sol.getBatchQuantity(i));

        }

    }

} // ManagementDecisions
