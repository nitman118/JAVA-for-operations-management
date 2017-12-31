import static org.junit.Assert.*;

import org.junit.Test;

public class MathOptEx00Test {

    private double delta = 0.0001;

    @Test
    public void testOptimizer1() {

        int nPlants = 3;
        int nProducts = 2;

        Plant p1 = new Plant(nProducts, 4.0);
        Plant p2 = new Plant(nProducts, 12.0);
        Plant p3 = new Plant(nProducts, 18.0);

        p1.setProductionTimePerBatch(0, 1);
        p2.setProductionTimePerBatch(1, 2);
        p3.setProductionTimePerBatch(0, 3);
        p3.setProductionTimePerBatch(1, 2);

        double[] profitPerProduct = new double[] { 3000, 5000 };

        Plant[] plants = new Plant[] { p1, p2, p3 };

        HelloLPOptimizer opt = new HelloLPOptimizer();
        HelloLPSolution sol = opt.optimize(nPlants, nProducts, plants, profitPerProduct);

        assertEquals(sol.getOptimalValue(), 36000.0, delta);
        assertEquals(sol.getBatchQuantity(0), 2.0, delta);
        assertEquals(sol.getBatchQuantity(1), 6.0, delta);

    }

    @Test
    public void testOptimizer2() {

        int nPlants = 3;
        int nProducts = 2;

        Plant p1 = new Plant(nProducts, 12.0);
        Plant p2 = new Plant(nProducts, 15.0);
        Plant p3 = new Plant(nProducts, 22.0);

        p1.setProductionTimePerBatch(0, 1);

        p2.setProductionTimePerBatch(1, 2);

        p3.setProductionTimePerBatch(0, 4);
        p3.setProductionTimePerBatch(1, 2);

        double[] profitPerProduct = new double[] { 200, 400 };

        Plant[] plants = new Plant[] { p1, p2, p3 };

        HelloLPOptimizer opt = new HelloLPOptimizer();
        HelloLPSolution sol = opt.optimize(nPlants, nProducts, plants, profitPerProduct);

        assertEquals(sol.getOptimalValue(), 3350.0, delta);

        assertEquals(sol.getBatchQuantity(0), 1.75, delta);
        assertEquals(sol.getBatchQuantity(1), 7.5, delta);

    }

    //
    @Test
    public void testOptimizer3() {

        int nPlants = 4;
        int nProducts = 3;
        //
        Plant p1 = new Plant(nProducts, 12.0);
        Plant p2 = new Plant(nProducts, 15.0);
        Plant p3 = new Plant(nProducts, 22.0);
        Plant p4 = new Plant(nProducts, 14.0);

        p1.setProductionTimePerBatch(0, 1);

        p2.setProductionTimePerBatch(1, 2);

        p3.setProductionTimePerBatch(1, 2);

        p4.setProductionTimePerBatch(1, 3);
        p4.setProductionTimePerBatch(2, 2);

        double[] profitPerProduct = new double[] { 300, 500, 600 };

        Plant[] plants = new Plant[] { p1, p2, p3, p4 };

        HelloLPOptimizer opt = new HelloLPOptimizer();
        HelloLPSolution sol = opt.optimize(nPlants, nProducts, plants, profitPerProduct);

        assertEquals(sol.getOptimalValue(), 7800.0, delta);
        assertEquals(sol.getBatchQuantity(0), 12.0, delta);
        assertEquals(sol.getBatchQuantity(1), 0.0, delta);
        assertEquals(sol.getBatchQuantity(2), 7.0, delta);

    }
} // MathOptEx00Test
