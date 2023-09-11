package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/house-robber/">打家劫舍</a>
 **/
public class No198 {


    int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums, 0);
    }

    /**
     * 走到第i个房子后，能获取的最大收益
     *
     * @param nums
     * @param i
     * @return
     */
    public int dp(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int pickFirst = nums[i] + dp(nums, i + 2);
        int pickSecond = dp(nums, i + 1);
        int res = Math.max(pickFirst, pickSecond);
        memo[i] = res;
        return memo[i];
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{2, 7, 9, 3, 1}, 12},
                {new int[]{1, 2, 3, 1}, 4},
                {new int[]{1, 1}, 1},
                {new int[]{1, 2}, 2},
                {new int[]{2}, 2},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] s, int expected) {
        int res = rob(s);
        System.out.println(res);
        System.out.println(expected);
        Assert.assertEquals(res, expected);
    }

}
