

public class Application {

    public Application() {
    } // constructor

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    } // main

    public void run() {

        SmallBucketCLSPOptimizer optimizer = new SmallBucketCLSPOptimizer();

        int T = 12;
        int nProducts = 2;

        double c = 30; // capacity

        double[] h = new double[] { 1, 1 }; // holding cost
        double[] s = new double[] { 40, 40 }; // setup cost
        double[] I0 = new double[] { 20, 20 }; // initial inventory

        double[][] demand = new double[][] { // demand of both products at each time period
                { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
                { 10, 10, 10, 10, 10, 10, 20, 10, 10, 10, 10, 10, 10, 10 }, };

        double[] ts = new double[] { 10, 10 }; // setup time
        double[] tp = new double[] { 1, 1 }; // production time

        SmallBucketCLSPSolution solution = optimizer.optimize(T, nProducts, c, h, s, I0, demand, ts, tp);

        System.out.println(solution.getOptimalValue());

        for (int t = 0; t < T; t++) {
            System.out.println("Time Period:" + t);
            for (int k = 0; k < nProducts; k++) {
                System.out.print("Product: " + k + ": " + "\t");
                System.out.print("Q:" + solution.getQ(k, t) + "\t");
                System.out.print("Y:" + solution.getY(k, t) + "\t");
                System.out.print("Z:" + solution.getZ(k, t) + "\t");
                System.out.print("I:" + solution.getI(k, t) + "\t");
                System.out.print("D:" + demand[k][t]);
                System.out.println("\t\t");
            }

            System.out.print("\n");

        } // for

    } // run

} // Application
