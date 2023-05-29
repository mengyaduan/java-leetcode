package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/partition-equal-subset-sum/">分割等和子集</a>
 **/
public class No416 {


    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            // 这里还是有疑问，为什么背包大小为0的时候，可以默认装满？
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{1, 5, 11, 5}, true},
                {new int[]{1, 2, 3, 5}, false},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] m, boolean expected) {
        boolean res = canPartition(m);
        Assert.assertEquals(res, expected);
    }

}
