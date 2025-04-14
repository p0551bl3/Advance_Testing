package poly.testing.vidu;

public class divzero {
    public static int divide(int a, int b) throws Exception {
        if(b == 0)
        {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
}
