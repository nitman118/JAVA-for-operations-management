

import static org.junit.Assert.*;

import org.junit.Test;

public class MathOptEx02_2Test {
	
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
				10,
				10
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
				10,
				10
				 },
		};
		
		double[] ts = new double[] { 10, 10 };
		double[] tp = new double[] { 1, 1 };
		
		SmallBucketCLSPSolution solution = optimizer.optimize ( T, nProducts, c, h, s, I0, demand, ts, tp );

    	assertEquals ( solution.getOptimalValue ( ), 540.0, DELTA );

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

	}

}
