package poly.testing.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import poly.testing.test.NumberUtils;

public class NumberUtilsTest {
    @ParameterizedTest
    @CsvSource({
            "5, true",      // Số nguyên dương
            "10, true",     // Số nguyên dương
            "0, false",     // Không phải số nguyên dương
            "-3, false",    // Số âm
            "-100, false"   // Số âm
    })
    public void testIsPositiveInteger(int input, boolean expected) {
        System.out.println("✅ Kiểm tra với giá trị: " + input);
        assertEquals(expected, NumberUtils.isPositiveInteger(input));
    }
}