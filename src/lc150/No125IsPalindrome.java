package lc150;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/valid-palindrome/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No125IsPalindrome {

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        s = s.toLowerCase();
        while (i < j) {
            while (i < j && !satisfy(s.charAt(i))) {
                i++;
            }
            while (i < j && !satisfy(s.charAt(j))) {
                j--;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public boolean satisfy(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertFalse(isPalindrome("race a car"));
        Assert.assertTrue(isPalindrome("   "));
        Assert.assertTrue(isPalindrome("  m "));
        Assert.assertFalse(isPalindrome("  0P "));
        Assert.assertTrue(isPalindrome("  0P0 "));

    }
}
