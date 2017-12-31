import static org.junit.Assert.*;

import org.junit.Test;

public class MathOptEx02TestExtended {
		
	private final double DELTA = 0.1;

	@Test
	public void test1() {
		
		SmallBucketCLSPOptimizer optimizer = new SmallBucketCLSPOptimizer ( );
		
		int T = 12;
		int nProducts = 2;
		
		double c = 30;
		
		double[] h = new double[] { 1, 1 };
		double[] s = new double[] { 40, 40 };
		double[] I0 = new double[] { 20, 20 };
		
		double[][] demand = new double[][] {
			{ 	10, 
				10, 
				10, 
				10, 
				10, 
				10, 
				10, 
				10, 
				10, 
				10,
				10, 
				10,
				},
			{ 	10, 
				10, 
				10, 
				10, 
				10, 
				10, 
				20, 
				10,
				10, 
				10,
				10, 
				10,
				 },
		};
		
		double[] ts = new double[] { 10, 10 };
		double[] tp = new double[] { 1, 1 };
		
		SmallBucketCLSPSolution solution = optimizer.optimize ( T, nProducts, c, h, s, I0, demand, ts, tp );

    	assertEquals ( solution.getOptimalValue ( ), 540.0, DELTA );

    	assertEquals ( solution.getQ ( 1, 4 ), 20, DELTA );
    	assertEquals ( solution.getQ ( 1, 5 ), 30, DELTA );
    	assertEquals ( solution.getQ ( 1, 6 ), 30, DELTA );
    	
    	assertEquals ( solution.getZ ( 1, 4 ), 1, DELTA );
    	assertEquals ( solution.getZ ( 1, 5 ), 0, DELTA );
    	assertEquals ( solution.getZ ( 1, 6 ), 0, DELTA );

	}
	
	@Test
	public void test2() {
		
		SmallBucketCLSPOptimizer optimizer = new SmallBucketCLSPOptimizer ( );
		
		int T = 12;
		int nProducts = 2;
		
		double c = 30;
		
		double[] h = new double[] { 1, 1 };
		double[] s = new double[] { 700, 40 };
		double[] I0 = new double[] { 0, 130 };
		
		double[][] demand = new double[][] {
			{ 	10, 
				10, 
				10, 
				10, 
				10, 
				10, 
				10, 
				10, 
				10, 
				10,
				10, 
				10,
				},
			{ 	10, 
				10, 
				10, 
				10, 
				10, 
				10, 
				20, 
				10,
				10, 
				10,
				10, 
				10,
				 },
		};
		
		double[] ts = new double[] { 10, 10 };
		double[] tp = new double[] { 1, 1 };
		
		SmallBucketCLSPSolution solution = optimizer.optimize ( T, nProducts, c, h, s, I0, demand, ts, tp );

    	assertEquals ( solution.getOptimalValue ( ), 2020.0, DELTA );


    	assertEquals ( solution.getQ ( 0, 0 ), 20, DELTA );
    	assertEquals ( solution.getQ ( 0, 1 ), 30, DELTA );
    	assertEquals ( solution.getQ ( 0, 2 ), 30, DELTA );
    	assertEquals ( solution.getQ ( 0, 3 ), 30, DELTA );
    	assertEquals ( solution.getQ ( 0, 4 ), 30, DELTA );
    	
    	
    	for ( int t = 0; t < T; t++ ) {
    		for ( int k = 0; k < nProducts; k++ ) {
    			if ( t == 0 && k == 0 ) {
    				continue;
    			}
    			assertEquals ( solution.getZ ( k, t ), 0, DELTA );
    		}
    	}

	}
	
	
	@Test
	public void test3() {
		
		SmallBucketCLSPOptimizer optimizer = new SmallBucketCLSPOptimizer ( );
		
		int T = 12;
		int nProducts = 2;
		
		double c = 30;
		

		double[] h = new double[] { 1, 1 };
		double[] s = new double[] { 700, 800 };
		double[] I0 = new double[] { 0, 20 };
		
		double[][] demand = new double[][] {
			{ 	10, 
				10, 
				10, 
				10, 
				10, 
				10, 
				10, 
				10, 
				10, 
				10,
				10, 
				10,
				},
			{ 	10, 
				10, 
				10, 
				10, 
				10, 
				10, 
				20, 
				10,
				10, 
				10,
				10, 
				10,
				 },
		};
		
		double[] ts = new double[] { 10, 10 };
		double[] tp = new double[] { 1, 1 };
		
		SmallBucketCLSPSolution solution = optimizer.optimize ( T, nProducts, c, h, s, I0, demand, ts, tp );

    	assertEquals ( solution.getOptimalValue ( ), 3490.0, DELTA );


    	assertEquals ( solution.getQ ( 0, 0 ), 20, DELTA );
    	assertEquals ( solution.getQ ( 0, 1 ), 30, DELTA );
    	assertEquals ( solution.getQ ( 0, 2 ), 0, DELTA );
    	assertEquals ( solution.getQ ( 0, 3 ), 0, DELTA );
    	assertEquals ( solution.getQ ( 0, 4 ), 0, DELTA );
    	assertEquals ( solution.getQ ( 0, 5 ), 20, DELTA );
    	assertEquals ( solution.getQ ( 0, 6 ), 30, DELTA );
    	assertEquals ( solution.getQ ( 0, 7 ), 30, DELTA );
    	assertEquals ( solution.getQ ( 0, 8 ), 0, DELTA );
    	assertEquals ( solution.getQ ( 0, 9 ), 0, DELTA );
    	assertEquals ( solution.getQ ( 0, 10 ), 0, DELTA );
    	assertEquals ( solution.getQ ( 0, 11 ), 0, DELTA );
    	
    	assertEquals ( solution.getQ ( 1, 0 ), 0, DELTA );
    	assertEquals ( solution.getQ ( 1, 1 ), 0, DELTA );
    	assertEquals ( solution.getQ ( 1, 2 ), 20, DELTA );
    	assertEquals ( solution.getQ ( 1, 3 ), 30, DELTA );
    	assertEquals ( solution.getQ ( 1, 4 ), 30, DELTA );
    	assertEquals ( solution.getQ ( 1, 5 ), 0, DELTA );
    	assertEquals ( solution.getQ ( 1, 6 ), 0, DELTA );
    	assertEquals ( solution.getQ ( 1, 7 ), 0, DELTA );
    	assertEquals ( solution.getQ ( 1, 8 ), 0, DELTA );
    	assertEquals ( solution.getQ ( 1, 9 ), 20, DELTA );
    	assertEquals ( solution.getQ ( 1, 10 ), 30, DELTA );
    	assertEquals ( solution.getQ ( 1, 11 ), 0, DELTA );
    	
    	

	}
	
	@Test
	public void test4() {
		
		SmallBucketCLSPOptimizer optimizer = new SmallBucketCLSPOptimizer ( );
		
		int T = 12;
		int nProducts = 2;
		
		double c = 120;
		
		double[] h = new double[] { 1, 1 };
		double[] s = new double[] { 700, 800 };
		double[] I0 = new double[] { 0, 20 };
		
		double[][] demand = new double[][] {
			{ 	5, 
				15, 
				5, 
				0, 
				0, 
				40, 
				50, 
				15, 
				0, 
				10,
				10, 
				0,
				},
			{ 	20, 
				0, 
				50, 
				60, 
				70, 
				20, 
				0, 
				0,
				0, 
				0,
				20, 
				20,
				 },
		};
		
		double[] ts = new double[] { 20, 10 };
		double[] tp = new double[] { 1, 2 };
		
		SmallBucketCLSPSolution solution = optimizer.optimize ( T, nProducts, c, h, s, I0, demand, ts, tp );

    	assertEquals ( solution.getOptimalValue ( ), 3865.0, DELTA );


    	assertEquals ( solution.getQ ( 0, 0 ), 100, DELTA );
    	assertEquals ( solution.getQ ( 0, 1 ), 0, DELTA );
    	assertEquals ( solution.getQ ( 0, 2 ), 0, DELTA );
    	assertEquals ( solution.getQ ( 0, 3 ), 0, DELTA );
    	assertEquals ( solution.getQ ( 0, 4 ), 0, DELTA );
    	assertEquals ( solution.getQ ( 0, 5 ), 0, DELTA );
    	assertEquals ( solution.getQ ( 0, 6 ), 100, DELTA );
    	assertEquals ( solution.getQ ( 0, 7 ), 0, DELTA );
    	assertEquals ( solution.getQ ( 0, 8 ), 0, DELTA );
    	assertEquals ( solution.getQ ( 0, 9 ), 0, DELTA );
    	assertEquals ( solution.getQ ( 0, 10 ), 0, DELTA );
    	assertEquals ( solution.getQ ( 0, 11 ), 0, DELTA );
    	
    	assertEquals ( solution.getQ ( 1, 0 ), 0, DELTA );
    	assertEquals ( solution.getQ ( 1, 1 ), 55, DELTA );
    	assertEquals ( solution.getQ ( 1, 2 ), 60, DELTA );
    	assertEquals ( solution.getQ ( 1, 3 ), 60, DELTA );
    	assertEquals ( solution.getQ ( 1, 4 ), 60, DELTA );
    	assertEquals ( solution.getQ ( 1, 5 ), 60, DELTA );
    	assertEquals ( solution.getQ ( 1, 6 ), 0, DELTA );
    	assertEquals ( solution.getQ ( 1, 7 ), 0, DELTA );
    	assertEquals ( solution.getQ ( 1, 8 ), 0, DELTA );
    	assertEquals ( solution.getQ ( 1, 9 ), 0, DELTA );
    	assertEquals ( solution.getQ ( 1, 10 ), 0, DELTA );
    	assertEquals ( solution.getQ ( 1, 11 ), 0, DELTA );
    	
	}

}


