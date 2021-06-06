import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testispalindrom(){
        OffByOne obo = new OffByOne();
        OffByOne obo5 = new OffByOne(5);
        assertFalse(Palindrome.isPalindrome("cat"));
        assertTrue(Palindrome.isPalindrome("racecar"));
        assertTrue(Palindrome.isPalindrome(""));
        assertTrue(Palindrome.isPalindrome("a"));
        assertTrue(Palindrome.isPalindrome("a", obo));
        assertTrue(Palindrome.isPalindrome("flake", obo));
        assertTrue(Palindrome.isPalindrome("acf", obo5));

    }
}
