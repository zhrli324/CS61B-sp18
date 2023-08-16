import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('4', '5'));
        assertTrue(offByOne.equalChars('y', 'z'));
        assertTrue(offByOne.equalChars('%', '&'));
        assertFalse(offByOne.equalChars('4', '7'));
        assertFalse(offByOne.equalChars('A', 'B'));
    }
    /*Uncomment this class once you've created your
    CharacterComparator interface and OffByOne class. */
}
