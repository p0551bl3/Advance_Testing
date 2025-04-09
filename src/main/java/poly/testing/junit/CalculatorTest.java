package poly.testing.junit;
//lab 2
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import poly.testing.test.Calculator;

public class CalculatorTest {
    //lab2
    private final Calculator calculator = new Calculator();
    //lab2
    @Test
    public void testAddition() {
        assertEquals(5, calculator.add(2, 3), "2 + 3 phải bằng 5");
        assertNotEquals(6, calculator.add(2, 3), "2 + 3 không thể bằng 6");
    }

    @Test
    public void testSubtraction() {
        assertEquals(1, calculator.subtract(3, 2), "3 - 2 phải bằng 1");
        assertNotEquals(0, calculator.subtract(3, 2), "3 - 2 không thể bằng 0");
    }

    @Test
    public void testMultiplication() {
        assertEquals(6, calculator.multiply(2, 3), "2 * 3 phải bằng 6");
        assertNotEquals(5, calculator.multiply(2, 3), "2 * 3 không thể bằng 5");
    }

    @Test
    public void testDivision() {
        assertEquals(2.0, calculator.divide(6, 3), 0.0001, "6 / 3 phải bằng 2.0");
        assertNotEquals(3.0, calculator.divide(6, 3), "6 / 3 không thể bằng 3.0");
    }

    @Test
    public void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(5, 0);
        }, "Chia cho 0 phải ném ra ArithmeticException");

        assertEquals("Không thể chia cho 0", exception.getMessage(), "Thông báo lỗi phải đúng");
    }

//    //lab3
//    private Calculator calculator2;
//    @BeforeEach
//    void setUp() {
//        calculator2 = new Calculator();
//    }
//
//    @Test
//    public void testDivideByZero() {
//        System.out.println("✅ Kiểm tra phép chia cho 0");
//        Exception exception = assertThrows(ArithmeticException.class, () -> calculator2.divide(10, 0));
//        assertEquals("Lỗi: Không thể chia cho 0!", exception.getMessage());
//    }
//
//    @Test
//    public void testParseNumberValid() {
//        System.out.println("✅ Kiểm tra parseNumber với số hợp lệ");
//        assertEquals(123, calculator2.parseNumber("123"));
//    }
//
//    @Test
//    public void testParseNumberInvalid() {
//        System.out.println("✅ Kiểm tra parseNumber với dữ liệu không hợp lệ");
//        Exception exception = assertThrows(NumberFormatException.class, () -> calculator2.parseNumber("abc"));
//        assertEquals("Lỗi: Giá trị nhập vào không phải là số hợp lệ!", exception.getMessage());
//    }
//
//    @Test
//    public void testParseNumberNull() {
//        System.out.println("✅ Kiểm tra parseNumber với giá trị null");
//        Exception exception = assertThrows(NullPointerException.class, () -> calculator2.parseNumber(null));
//        assertEquals("Lỗi: Dữ liệu nhập vào là null!", exception.getMessage());
//    }
}
