import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator offByN = new OffByN(4);

    @Test
    public void testEqualChars() {
        assertTrue(offByN.equalChars('a', 'e'));
        assertFalse(offByN.equalChars('e', 'h'));
    }
}
