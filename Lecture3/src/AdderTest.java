import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AdderTest {

    /**
     * Test default constructor
     */

    @Test
    public void testAdder() {
        Adder a1 = new Adder();
        assertEquals(0, a1.getNumValues());
        assertEquals(0, a1.getSum());

    }
    
    /**
    * Test second constructor
    */
    @Test
    public void testAdderInt1() {
    Adder a1 = new Adder(5);
    assertEquals(5, a1.getSum());
    assertEquals(1, a1.getNumValues());
    }
    /**
    * Test second constructor
    */
    @Test
    public void testAdderInt2() {
    Adder a1 = new Adder(-5);
    assertEquals(-5, a1.getSum(),0.0);
    assertEquals(1, a1.getNumValues());
    }
    /**
    * Test second constructor
    */
    @Test
    public void testAdderInt3() {
    Adder a1 = new Adder(0);
    assertEquals(0, a1.getSum(),0.0);
    assertEquals(1, a1.getNumValues());
    }
    /**
    * Test for getSum
    */
    @Test
    public void testGetSum1() {
    Adder a1 = new Adder();
    a1.add(2);
    assertEquals(2, a1.getSum(),0.0);
}
    /**
    * Test for getSum
    */
    @Test
    public void testGetSum2() {
    Adder a1 = new Adder();
    a1.add(2);
    a1.add(2);
    assertEquals(4, a1.getSum(),0.0);
    }
    
    /**
    * Test for getSum
    */
    @Test
    public void testGetSum3() {
    Adder a1 = new Adder();
    a1.add(1);
    a1.add(2);
    a1.add(3);
    assertEquals(6, a1.getSum(),0.0);
    }
    
    /**
    * Test for plusOne
    */
    @Test
    public void testPlusOne1() {
    Adder a1 = new Adder();
    a1.plusOne();
    a1.plusOne();
    a1.plusOne();
    a1.plusOne();
    assertEquals(4, a1.getSum(),0.0);
    }
    
    /**
    * Test for plusOne
    */
    @Test
    public void testPlusOne2() {
    Adder a1 = new Adder(6);
    a1.plusOne();
    a1.plusOne();
    a1.plusOne();
    a1.plusOne();
    assertEquals(10, a1.getSum(),0.0);
    }
    
    /**
    * Test for getNumValues
    */
    @Test
    public void testGetNumValues1() {
    Adder a1 = new Adder();
    a1.add(1);
    a1.add(2);
    a1.add(3);
    assertEquals(3, a1.getNumValues());
    }
    
    /**
    * Test for getNumValues
    */
    @Test
    public void testGetNumValues2() {
    Adder a1 = new Adder();
    a1.add(1);
    a1.add(2);
    a1.add(3);
    a1.add(3);
    a1.add(3);
    a1.add(3);
    assertEquals(6, a1.getNumValues());
    }
    
    /**
    * Test for getNumValues
    */
    @Test
    public void testGetNumValues3() {
    Adder a1 = new Adder();
    a1.plusOne();
    a1.plusOne();
    a1.plusOne();
    a1.plusOne();
    // still 0 since no value passed
    assertEquals(0, a1.getNumValues());
    }
}
