package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/jump-game-vi/?show=1">No1696 跳跃游戏II</a>
 **/
public class No1696OverLimitToo {
    /**
     * Input: nums = [10,-5,-2,4,0,3], k = 3
     * Output: 17
     * Explanation: You can choose your jumps forming the subsequence [10,4,3] (underlined above). The sum is 17.
     **/

    int[] memo;

    public int maxResult(int[] nums, int k) {
        memo = new int[nums.length];
        int[] numsNew = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsNew[i] = nums[nums.length - 1 - i];
        }
        Arrays.fill(memo, 0);
        memo[0] = numsNew[0];
        for (int i = 1; i < numsNew.length; i++) {
            dp(numsNew, i, k);
        }
        return memo[numsNew.length - 1];
    }

    public void dp(int[] nums, int targetIndex, int k) {
        boolean isSet = false;
        for (int i = 1; i <= k; i++) {
            int lastStep = targetIndex - i;
            if (lastStep >= 0) {
                int tmp = nums[targetIndex] + memo[lastStep];
                if (isSet) {
                    memo[targetIndex] = Math.max(memo[targetIndex], tmp);
                } else {
                    memo[targetIndex] = tmp;
                    isSet = true;
                }
            }
        }
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{1}, 2, 1},
                {new int[]{1, 2}, 2, 3},
                {new int[]{1, 2, -3}, 2, 0},
                {new int[]{10, -5, -2, 4, 0, 3}, 3, 17},
                {new int[]{1, -1, -2, 4, -7, 3}, 2, 7},
                {new int[]{1, -5, -20, 4, -1, 3, -6, -3}, 2, 0},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] nums, int k, int expected) {
        int res = maxResult(nums, k);
        Assert.assertEquals(res, expected);
    }
}
