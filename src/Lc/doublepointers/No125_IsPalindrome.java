package Lc.doublepointers;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/valid-palindrome/description/">回文字符串</a>
 **/
public class No125_IsPalindrome {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        s = s.toLowerCase();
        while (i < j) {
            while (i < s.length() && !isAlphaOrNum(s.charAt(i))) {
                i++;
            }
            while (j >= 0 && !isAlphaOrNum(s.charAt(j))) {
                j--;
            }
            if (i >= j) {
                break;
            } else if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isAlphaOrNum(char item) {
        return (item >= 'a' && item <= 'z') || (item >= '0' && item <= '9');
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("   "));
        System.out.println(isPalindrome("  j "));
        System.out.println(isPalindrome("  0P "));

    }
}
