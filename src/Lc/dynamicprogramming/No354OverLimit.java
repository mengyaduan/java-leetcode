package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/russian-doll-envelopes/">俄罗斯套娃信封</a>
 **/
public class No354OverLimit {


    /**
     * 状态转移方程：<p>
     * dp[n] = max(1, dp[i]+1(when nums[i]<nums[n]))
     **/

    int[] memo;
    int[] dp;

    public int maxEnvelopes(int[][] envelopes) {
        memo = new int[envelopes.length];
        dp = new int[envelopes.length];
        int maxRes = 1;
        Arrays.fill(memo, 0);
        Arrays.fill(dp, 1);
        int count = 0;
        while (count < envelopes.length) {
            int index = findSmallestX(envelopes);
            for (int i = 0; i < envelopes.length; i++) {
                if (index == i || memo[i] == 1) {
                    continue;
                }
                if (envelopes[i][0] > envelopes[index][0] && envelopes[i][1] > envelopes[index][1]) {
                    dp[i] = Math.max(dp[i], dp[index] + 1);
                }
                maxRes = Math.max(maxRes, dp[i]);

            }
            memo[index] = 1;
            count++;
        }
        return maxRes;
    }

    public int findSmallestX(int[][] envelopes) {
        int index = 0;
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < envelopes.length; i++) {
            if (memo[i] == 0 && envelopes[i][0] < smallest) {
                smallest = envelopes[i][0];
                index = i;
            }
        }
        return index;
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
//                {new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}, 3},
//                {new int[][]{{1, 1}, {1, 1}, {1, 1}, {1, 1}}, 1},
                {new int[][]{{30, 50}, {12, 2}, {3, 4}, {12, 15}}, 3},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[][] envelopes, int expected) {
        int res = maxEnvelopes(envelopes);
        Assert.assertEquals(res, expected);
    }


}
