package LcSecond.string;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/longest-palindromic-substring/description/">最长回文子串</a>
 **/
public class No5_LongestPalindromicSubstring {

    /**
     * 中心扩散法
     **/
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int res = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && s.charAt(left) == cur) {
                // 向左扩散，找到第一个不一样的字符
                left--;
            }
            while (right < s.length() && s.charAt(right) == cur) {
                // 向右扩散，找到第一个不一样的数字
                right++;
            }
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            int lenNow = (right - 1) - (left + 1) + 1;
            if (lenNow > res) {
                res = lenNow;
                start = left + 1;
                end = right;
            }
        }
        return s.substring(start, end);
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("abcd"));

    }
}
