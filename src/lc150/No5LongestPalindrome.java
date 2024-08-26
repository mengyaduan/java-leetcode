package lc150;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/longest-palindromic-substring/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No5LongestPalindrome {
    public String longestPalindrome(String s) {
        String result = "";
        int length = Integer.MIN_VALUE;
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (i > 0 && cs[i] == cs[i - 1]) {
                continue;
            }
            int[] item = expandFromMid(cs, i);
            if (item[1] - item[0] + 1 > length) {
                length = item[1] - item[0] + 1;
                result = s.substring(item[0], item[1] + 1);
            }
        }
        return result;
    }

    private int[] expandFromMid(char[] cs, int i) {
        int[] result = new int[]{i, i};
        int left = i - 1, right = i + 1;
        while (left >= 0 && cs[left] == cs[i]) {
            left--;
            result[0]--;
        }
        while (right < cs.length && cs[right] == cs[i]) {
            right++;
            result[1]++;
        }
        while (left >= 0 && right < cs.length && cs[left] == cs[right]) {
            right++;
            left--;
            result[0]--;
            result[1]++;
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("abbc"));
        System.out.println(longestPalindrome("abba"));
        System.out.println(longestPalindrome("aaaaaaa"));

    }


}
