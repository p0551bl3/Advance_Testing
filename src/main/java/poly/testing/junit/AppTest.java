package poly.testing.junit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import poly.testing.test.App;
//lab2
public class AppTest {

    @Test
    public void testIsEvenNumber2() {
        App app = new App();
        boolean result = app.isEvenNumber(2);
        assertTrue(result);
    }

    @Test
    public void testIsEvenNumber4() {
    App app = new App();
        boolean result = app.isEvenNumber(4);//doi thanh 3 thi failed
        assertTrue(result);
    }
}
