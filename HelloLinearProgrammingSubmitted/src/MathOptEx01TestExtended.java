import static org.junit.Assert.*;

import org.junit.Test;

public class MathOptEx01TestExtended {
	/*
	int nPlants = 3;
	int nProducts = 2;
	
	Plant p1 = new Plant ( nProducts, 4.0 );
	Plant p2 = new Plant ( nProducts, 12.0 );
	Plant p3 = new Plant ( nProducts, 18.0 );
	
	p1.setProductionTimePerBatch ( 0, 0.5 );
	
	p2.setProductionTimePerBatch ( 1, 1.25 );
	
	p3.setProductionTimePerBatch ( 0, 2.5 );
	p3.setProductionTimePerBatch ( 1, 1.5 );

	
	double[] profitPerProduct = new double[] { 6500, 8000 };
	*/
	
	@Test
	public void plantToExtendCapacity ( ) {
		ManagementDecisions decisions = new ManagementDecisions ( );
		
		assertEquals ( decisions.getQ1 ( ), 2 );
	}
	
	@Test
	public void plantShadowPrice ( ) {
		ManagementDecisions decisions = new ManagementDecisions ( );
		
		assertEquals ( decisions.getQ2 ( ), 3280 );
	}
	
	@Test
	public void plantMaxRange ( ) {
		ManagementDecisions decisions = new ManagementDecisions ( );
		
		assertEquals ( decisions.getQ3 ( ), 15 );
	}
}
