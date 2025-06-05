package Lc119;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LCR094 {


    int[][] palindrome;
    int[] memo;

    public int minCut(String s) {
        int n = s.length();
        palindrome = new int[n][n];
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dp(s.length() - 1, s.toCharArray());
    }

    public int dp(int r, char[] sc) {
        if (isPalindrome(0, r, sc)) {
            // 已经是回文的，不用再切割了
            return 0;
        }
        if (memo[r] != -1) {
            return memo[r];
        }
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= r; i++) {
            if (isPalindrome(i, r, sc)) {
                // 如果指定区间是回文了，那么开始dp，否则需要缩小区间
                result = Math.min(result, dp(i - 1, sc) + 1);
            }
        }
        memo[r] = result;
        return result;
    }

    public boolean isPalindrome(int l, int r, char[] sc) {
        if (l >= r) {
            return true;
        }
        if (palindrome[l][r] != 0) {
            return palindrome[l][r] == 1;
        }
        boolean res = sc[l] == sc[r] && isPalindrome(l + 1, r - 1, sc);
        palindrome[l][r] = res ? 1 : 2; // 记忆化
        return res;
    }

}
