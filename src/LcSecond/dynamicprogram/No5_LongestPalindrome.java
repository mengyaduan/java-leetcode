package LcSecond.dynamicprogram;

import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/longest-palindromic-substring/">最长回文子串</a>
 */
public class No5_LongestPalindrome {

    public String longestPalindrome(String s) {
        String maxLen = s.substring(0, 1);

        for (int i = 1; i < s.length(); i++) {
            String item = expandItem(s, i);
            if (item.length() > maxLen.length()) {
                maxLen = item;
            }
        }
        return maxLen;
    }

    private String expandItem(String s, int mid) {
        int n = s.length();
        int i = mid - 1, j = mid + 1;
        while (i >= 0 && s.charAt(i) == s.charAt(mid)) {
            i--;
        }
        while (j < n && s.charAt(j) == s.charAt(mid)) {
            j++;
        }
        while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }

    @Test(description = "")
    public void test() throws Exception {
        String s = "babad";
        System.out.println(longestPalindrome(s));


    }
}
