import static org.junit.Assert.*;

import org.junit.Test;

public class MathOptEx00TestExtended {
	
	private double delta = 0.0001;

	@Test
	public void testPlantConstructor ( ) {
		
		// boundary value testing on plant constructor
		
		try { 
			Plant p1 = new Plant ( 2, -2.0 );
			
			// @ we arrived here, so we were able to insert a invalid value
			
			fail ( );
			
		} catch ( AssertionError ae ) {
			// good :))
		}
		
		try { 
			Plant p1 = new Plant ( 2, 0.0 );
			
			// good :))			
			
		} catch ( AssertionError ae ) {
			
			// @ no expection should have been thrown, 0.0 should be valid
			
			fail ( );
		}
		
	} // testPlantConstructor
	
	@Test
	public void testPlantAvailableProductionTime ( ) {
		
		// getter setter testing
		
		try { 
			
			Plant p1 = new Plant ( 2, 3.0 );
			
			assertEquals ( 3.0, p1.getAvailableProductionTime ( ), delta );
			
			p1.setAvailableProductionTime ( 5.0 );
			
			assertEquals ( 5.0, p1.getAvailableProductionTime ( ), delta );
			
		} catch ( AssertionError ae ) {
			fail ( );
		}
		
		
		try { 
			
			Plant p1 = new Plant ( 2, 4.0 );
			
			p1.setAvailableProductionTime ( -5.0 );
					
			fail ( );
			
		} catch ( AssertionError ae ) {
			// good :))	
		}
		
	} // testPlantAvailableProductionTime
	
	@Test
	public void testPlantProductionTimePerBatch ( ) {
		
		// getter setter testing
		
			
		Plant p1 = new Plant ( 2, 3.0 );
		
		assertEquals ( 0.0, p1.getProductionTimePerBatch ( 0 ), 0.0 );
		assertEquals ( 0.0, p1.getProductionTimePerBatch ( 1 ), 0.0 );
		
		p1.setProductionTimePerBatch ( 1, 2 );
		
		assertEquals ( 2.0, p1.getProductionTimePerBatch ( 1 ), 0.0 );
			
		
		
		try { 
			
			p1.setProductionTimePerBatch ( -1, 2 );
			
			fail ( );
			
		} catch ( AssertionError ae ) {
			// good
		}
		
		try { 
			
			p1.setProductionTimePerBatch ( 1, -2 );
			
			fail ( );
			
		} catch ( AssertionError ae ) {
			// good
		}
		
	} // testPlantConstructor
	
	@Test
	public void testOptimizer1 ( ) {
		
		int nPlants = 3;
		int nProducts = 2;
		
		Plant p1 = new Plant ( nProducts, 4.0 );
		Plant p2 = new Plant ( nProducts, 12.0 );
		Plant p3 = new Plant ( nProducts, 18.0 );
		
		p1.setProductionTimePerBatch ( 0, 1 );
		
		p2.setProductionTimePerBatch ( 1, 2 );
		
		p3.setProductionTimePerBatch ( 0, 3 );
		p3.setProductionTimePerBatch ( 1, 2 );
		
		double[] profitPerProduct = new double[] { 3000, 5000 };
		
		Plant[] plants = new Plant[] { p1, p2, p3 };
		
		HelloLPOptimizer opt = new HelloLPOptimizer ( );
		HelloLPSolution sol = opt.optimize ( nPlants, nProducts, plants, profitPerProduct );
		
		assertEquals ( sol.getOptimalValue ( ), 36000.0, delta );
		
		assertEquals ( sol.getBatchQuantity ( 0 ), 2.0, delta );
		assertEquals ( sol.getBatchQuantity ( 1 ), 6.0, delta );
		
	} // testOptimizer1
	
	@Test
	public void testOptimizer2 ( ) {
		
		int nPlants = 3;
		int nProducts = 2; 
		
		Plant p1 = new Plant ( nProducts, 12.0 );
		Plant p2 = new Plant ( nProducts, 15.0 );
		Plant p3 = new Plant ( nProducts, 22.0 );
		
		p1.setProductionTimePerBatch ( 0, 1 );
		
		p2.setProductionTimePerBatch ( 1, 2 );
		
		p3.setProductionTimePerBatch ( 0, 4 );
		p3.setProductionTimePerBatch ( 1, 2 );
		
		double[] profitPerProduct = new double[] { 200, 400 };
		
		Plant[] plants = new Plant[] { p1, p2, p3 };
		
		HelloLPOptimizer opt = new HelloLPOptimizer ( );
		HelloLPSolution sol = opt.optimize ( nPlants, nProducts, plants, profitPerProduct );
		
		assertEquals ( sol.getOptimalValue ( ), 3350.0, delta );
		
		assertEquals ( sol.getBatchQuantity ( 0 ), 1.75, delta );
		assertEquals ( sol.getBatchQuantity ( 1 ), 7.5, delta );
		
	} // testOptimizer2
	
	@Test
	public void testOptimizer3 ( ) {
		
		int nPlants = 4;
		int nProducts = 3;

		Plant p1 = new Plant ( nProducts, 12.0 );
		Plant p2 = new Plant ( nProducts, 15.0 );
		Plant p3 = new Plant ( nProducts, 22.0 );
		Plant p4 = new Plant ( nProducts, 14.0 );
		
		p1.setProductionTimePerBatch ( 0, 1 );
		
		p2.setProductionTimePerBatch ( 1, 2 );
		
		p3.setProductionTimePerBatch ( 1, 2 );
		
		p4.setProductionTimePerBatch ( 1, 3 );
		p4.setProductionTimePerBatch ( 2, 2 );
		
		double[] profitPerProduct = new double[] { 300, 500, 600 };
		
		Plant[] plants = new Plant[] { p1, p2, p3, p4 };
		
		HelloLPOptimizer opt = new HelloLPOptimizer ( );
		HelloLPSolution sol = opt.optimize ( nPlants, nProducts, plants, profitPerProduct );
		
		assertEquals ( sol.getOptimalValue ( ), 7800.0, delta );
		
		assertEquals ( sol.getBatchQuantity ( 0 ), 12.0, delta );
		assertEquals ( sol.getBatchQuantity ( 1 ), 0.0, delta );
		assertEquals ( sol.getBatchQuantity ( 2 ), 7.0, delta );
			
	} // testOptimizer3
	
	@Test
	public void testOptimizerNegativeProfit ( ) {
		
		int nPlants = 3;
		int nProducts = 2; 
		
		Plant p1 = new Plant ( nProducts, 4.0 );
		Plant p2 = new Plant ( nProducts, 12.0 );
		Plant p3 = new Plant ( nProducts, 18.0 );
		
		p1.setProductionTimePerBatch ( 0, 1 );
		
		p2.setProductionTimePerBatch ( 1, 2 );
		
		p3.setProductionTimePerBatch ( 0, 3 );
		p3.setProductionTimePerBatch ( 1, 2 );
		
		double[] profitPerProduct = new double[] { -300, -500 };
		
		Plant[] plants = new Plant[] { p1, p2, p3 };
		
		HelloLPOptimizer opt = new HelloLPOptimizer ( );
		HelloLPSolution sol = opt.optimize ( nPlants, nProducts, plants, profitPerProduct );
		
		assertEquals ( sol.getOptimalValue ( ), 0.0, delta );
		
	} // testOptimizerNegativeProfit

} // MathOptEx00TestExtended
