package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/longest-increasing-subsequence/">最长增序子序列</a>
 **/
public class No300 {

    /**
     * 状态转移方程：<p>
     * dp[n] = max(1, dp[i]+1(when nums[i]<nums[n]))
     **/


    public int lengthOfLIS(int[] nums) {
        int maxRes = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxRes = Math.max(dp[i], maxRes);
                }
            }
        }
        return maxRes;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{10, 9, 2, 5, 3, 7, 101, 18}, 4},
                {new int[]{0, 1, 0, 3, 2, 3}, 4},
                {new int[]{7, 7, 7, 7, 7, 7, 7}, 1},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] nums, int expected) {
        int res = lengthOfLIS(nums);
        Assert.assertEquals(res, expected);
    }


}
