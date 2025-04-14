package poly.testing.vidu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class divzeroTest {
    @Test
    public void testMathUtils1()
    {
        assertThrows(ArithmeticException.class, () ->{
            divzero.divide(1,1);
        });
    }

    @Test
    public void testMathUtils2()
    {
        try{

        }catch(Exception e){
            assertEquals(e.getMessage(), "divide by zero");
    }
    }
}