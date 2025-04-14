package poly.testing.vidu;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestJunit {
    @Test
    public void testSetup()
    {
        String str = "Fpoly demo Junit";
        assertEquals("Fpoly demo Junit", str); //so sanh str giong voi Fpoly demo Junit
    }
}
