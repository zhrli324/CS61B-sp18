import static org.junit.Assert.*;

import org.junit.Test;

public class FilkTest
{
    @Test
    public void testIsSameNumber()
    {
        assertTrue(Flik.isSameNumber(344, 344));
        assertFalse(Flik.isSameNumber(531, 152));
    }
}
