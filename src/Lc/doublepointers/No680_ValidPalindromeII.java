package Lc.doublepointers;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/valid-palindrome-ii/description/">验证回文字符串ii</a>
 **/
public class No680_ValidPalindromeII {

    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return valid(s, i + 1, j) || valid(s, i, j - 1);
            }
        }
        return true;
    }

    public boolean valid(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome("abcda"));

    }
}
