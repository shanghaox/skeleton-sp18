import org.junit.Test;

import static org.junit.Assert.*;

public class FilkTest {
    @Test(timeout = 1000)
    public void testIsSameNumber() {
        assertTrue(Flik.isSameNumber(99, 99));
    }
}
