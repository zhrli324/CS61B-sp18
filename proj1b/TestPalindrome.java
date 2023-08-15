import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque()
    {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } /*Uncomment this class once you've created your Palindrome class. */

    @Test
    public void testIsPalindrome()
    {
        String test1 = "ahfisifha";
        String test2 = "ahfisshfha";
        String test3 = "r";
        String test4 = "";

        assertTrue(palindrome.isPalindrome(test1));
        assertFalse(palindrome.isPalindrome(test2));
        assertTrue(palindrome.isPalindrome(test3));
        assertTrue(palindrome.isPalindrome(test4));
    }

    @Test
    public void testIsOffByOnePalindrome()
    {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", cc));
        assertFalse(palindrome.isPalindrome("abc", cc));
    }
}
