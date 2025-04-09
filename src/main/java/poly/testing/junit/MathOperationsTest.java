package poly.testing.junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import poly.testing.test.MathOperations;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Cho phép sử dụng @BeforeAll và @AfterAll mà không cần static
public class MathOperationsTest {
    private MathOperations mathOperations;

    @BeforeAll
    void setUpBeforeAll() {
        System.out.println("⚡ [BẮT ĐẦU] Cấu hình trước tất cả các bài kiểm thử...");
    }

    @BeforeEach
    void setUp() {
        System.out.println("🔹 Khởi tạo đối tượng MathOperations trước mỗi bài kiểm thử");
        mathOperations = new MathOperations();
    }

    @Test
    public void testAddition() {
        System.out.println("✅ Kiểm tra phép cộng");
        assertEquals(7, mathOperations.add(3, 4));
    }

    @Test
    public void testSubtraction() {
        System.out.println("✅ Kiểm tra phép trừ");
        assertEquals(2, mathOperations.subtract(5, 3));
    }

    @Test
    public void testMultiplication() {
        System.out.println("✅ Kiểm tra phép nhân");
        assertEquals(15, mathOperations.multiply(3, 5));
    }

    @Test
    public void testDivision() {
        System.out.println("✅ Kiểm tra phép chia");
        assertEquals(2.0, mathOperations.divide(10, 5), 0.0001);
    }

    @Test
    public void testDivisionByZero() {
        System.out.println("✅ Kiểm tra phép chia cho 0");
        Exception exception = assertThrows(ArithmeticException.class, () -> mathOperations.divide(8, 0));
        assertEquals("Không thể chia cho 0", exception.getMessage());
    }

    @AfterEach
    void tearDown() {
        System.out.println("🔻 Dọn dẹp sau mỗi bài kiểm thử");
    }

    @AfterAll
    void tearDownAfterAll() {
        System.out.println("🏁 [KẾT THÚC] Dọn dẹp sau tất cả các bài kiểm thử...");
    }
}
