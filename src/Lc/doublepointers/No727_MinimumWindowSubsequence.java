package Lc.doublepointers;

import org.testng.annotations.Test;

/**
 * @see <a href="">leetcode付费题目，从其他网站ac</a>
 **/
public class No727_MinimumWindowSubsequence {

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        String minRes = "";
        for (int k = 0; k < s.length(); k++) {
            int left = -1;
            int i = k, j = 0;
            while (i < s.length() && j < t.length()) {
                if (s.charAt(i) != t.charAt(j)) {
                    i++;
                    continue;
                }
                if (s.charAt(i) == t.charAt(j)) {
                    if (left == -1) {
                        left = i;
                    }
                    i++;
                    j++;
                }
            }
            if (j < t.length()) {
                continue;
            }
            String resTemp = s.substring(left, i);
            if (minRes.isEmpty()) {
                minRes = resTemp;
            } else {
                minRes = resTemp.length() < minRes.length() ? resTemp : minRes;
            }
        }
        return minRes;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(minWindow("abbc", "ac"));
        System.out.println(minWindow("abbc", "abc"));
        System.out.println(minWindow("abbc", "bc"));
        System.out.println(minWindow("abbc", "ab"));
        System.out.println(minWindow("abbc", "ad"));

    }
}

