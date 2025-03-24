package Lc119;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LCR020 {

    int[][] memo;

    public int countSubstrings(String s) {
        char[] sc = s.toCharArray();
        memo = new int[sc.length][sc.length];
        for (int i = 0; i < memo.length; i++) {
            // 单个字符一定是回文的
            memo[i][i] = 1;
        }
        int result = 0;
        for (int i = 0; i < sc.length; i++) {
            result += count(sc, i, sc.length - 1);
        }
        return result;
    }

    /**
     * 以left为起点的所有子串个数
     */
    private int count(char[] sc, int left, int right) {
        int res = 0;
        for (int i = right; i >= left; i--) {
            boolean item;
            if (memo[left][i] == 0) {
                item = validPalindrome(sc, left, i);
            } else {
                item = memo[left][i] == 1;
            }
            if (item) {
                res++;
            }
        }
        return res;
    }

    private boolean validPalindrome(char[] sc, int x, int y) {
        int i = x, j = y;
        while (i < j && sc[i] == sc[j]) {
            i++;
            j--;
        }
        if (i >= j) {
            memo[x][y] = 1;
            return true;
        } else {
            memo[x][y] = 2;
            return false;
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        String s = "ababa";
        Assert.assertEquals(countSubstrings(s), 9);
        s = "aababa";
        Assert.assertEquals(countSubstrings(s), 11);

    }
}
