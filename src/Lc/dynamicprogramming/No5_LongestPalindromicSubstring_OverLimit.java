package Lc.dynamicprogramming;

import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/longest-palindromic-substring/description/">最长回文子串（连续子串）</a>
 **/
public class No5_LongestPalindromicSubstring_OverLimit {
    HashMap<String, String> memo;

    public String longestPalindrome(String s) {
        memo = new HashMap<>();
        return dp2(s, 0, s.length() - 1);
    }

    public String dp2(String s, int i, int j) {
        // 终止
        if (i == j) {
            return s.charAt(i) + "";
        }
        if (i > j) {
            return "";
        }

        // 查询memo
        String key = i + "_" + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        //dp
        String res1 = "";
        if (s.charAt(i) == s.charAt(j)) {
            String inner = dp2(s, i + 1, j - 1);
            if (inner.length() == j - i - 1) {
                res1 = s.charAt(i) + inner + s.charAt(j);
            } else {
                res1 = inner;
            }
        }
        String res2 = dp2(s, i + 1, j);
        String res3 = dp2(s, i, j - 1);
        String res = res1.length() > res2.length() ? res1 : res2;
        res = res.length() > res3.length() ? res : res3;
        memo.put(key, res);
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("asdfdsa"));
        System.out.println(longestPalindrome("aacabdkacaa"));

    }


}




