import static org.junit.Assert.*;

import org.junit.Test;

public class LoanTest {
	
	
		/**
		* Based on following data:
		* <pre>Loan Amount (Euros+Cents):310000
		* Annual Interest Rate (e.g., 3,5):2,5
		* Loan Period - # of years:15
		* Loan Amount: EUR310000,00
		* Annual Interest Rate:2,50%
		* Loan Period (years): 15,00
		* Monthly payment is EUR 2067,05
		* TOTAL payment is EUR 372068,38</pre>
		*/
		final Loan l1= new Loan(310000.0, 2.5, 15);
		
		/**
		* Based on following data :
		* <pre>Loan Amount: EUR200000,00
		* Annual Interest Rate:5,00%
		* Loan Period (years): 10,00
		* Monthly payment is EUR 2121,31
		* TOTAL payment is EUR 254557,24</pre>
		*/
		final Loan l2= new Loan(200000.0, 0.0, 10);
		// testing
		
		
		@Test
		public void testGetAmount1() {
		assertEquals(310000, l1.getAmount(), 0.000005);
	}
		
		@Test
		public void testGetPeriod1() {
			assertEquals(15,l1.getPeriod(),0.000005);
		}
		
		@Test
		public void testGetRate1() {
		assertEquals(2.5, l1.getRate(), 0.000005);
		}
		
		@Test
		public void testGetTotalPayment1() {
		assertEquals(372068.38, l1.getTotalPayment(), 0.005);
		}
		//testing l2
		@Test
		public void testGetAmount2() {
		assertEquals(200000, l2.getAmount(), 0.000005);
		}
		@Test
		public void testGetPeriod2() {
		assertEquals(10, l2.getPeriod(), 0.000005);
		}
		@Test
		public void testGetRate2() {
		assertEquals(0, l2.getRate(), 0.000005);
		}
		@Test
		public void testGetMonthlyPayment2() {
		assertEquals(1666.67, l2.getMonthlyPayment(), 0.005);
		}
		@Test
		public void testGetTotalPayment2() {
		assertEquals(200000.00, l2.getTotalPayment(), 0.005);
		}
}	


