package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/constrained-subsequence-sum/?show=1">带限制的子序列和</a>
 **/
public class No1425OverLimit {

    int[][] memo;

    public int constrainedSubsetSum(int[] nums, int k) {
        memo = new int[nums.length + 1][2];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        int res = Math.max(dp(0, nums, k, 0), dp(0, nums, k, 1));
        return res;
    }

    int dp(int index, int[] nums, int k, int containsFirst) {
        if (index >= nums.length) {
            return 0;
        }
        if (index == nums.length - 1) {
            memo[index][containsFirst] = nums[index];
            return nums[index];
        }
        if (memo[index][containsFirst] != Integer.MIN_VALUE) {
            return memo[index][containsFirst];
        }
        int res = Integer.MIN_VALUE;
        int resContainsFirst = Integer.MIN_VALUE;
        if (containsFirst == 0) {
            // index位丢掉，则需要考虑剩下的子序列
            int a = Math.max(dp(index + 1, nums, k, 0), dp(index + 1, nums, k, 1));
            res = Math.max(res, a);
        }
        int b = nums[index];
        res = Math.max(res, b);
        resContainsFirst = Math.max(resContainsFirst, b);
        for (int i = 1; i <= k; i++) {
            // index位不丢，则后续的必须包含首位
            int c = nums[index] + dp(index + i, nums, k, 1);
            res = Math.max(res, c);
            resContainsFirst = Math.max(resContainsFirst, c);
        }
        memo[index][1] = resContainsFirst;
        memo[index][containsFirst] = res;
        return memo[index][containsFirst];
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{10}, 1, 10},
                {new int[]{-10}, 1, -10},
                {new int[]{5, -10}, 1, 5},
                {new int[]{5, -10}, 2, 5},
                {new int[]{10, -2, -10, -5, 20}, 2, 23},
                {new int[]{-10, -5, 20}, 2, 20},
                {new int[]{20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10}, 19, 20},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] nums, int k, int expected) {
        int res = constrainedSubsetSum(nums, k);
        Assert.assertEquals(res, expected);
    }


}
