package Lc.dynamicprogramming;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/jump-game-vi/?show=1">No1696 跳跃游戏II</a>
 **/
public class No1696OverLimit {
    /**
     * Input: nums = [10,-5,-2,4,0,3], k = 3
     * Output: 17
     * Explanation: You can choose your jumps forming the subsequence [10,4,3] (underlined above). The sum is 17.
     **/

    int[] memo;
    boolean[] hasRecorded;
    int maxRes;

    public int maxResult(int[] nums, int k) {
        maxRes = Integer.MIN_VALUE;
        memo = new int[nums.length + 1];
        hasRecorded = new boolean[nums.length + 1];
        Arrays.fill(memo, 0);
        Arrays.fill(hasRecorded, false);
        return dp(nums, 0, k);
    }

    int count1 = 0;
    int count2 = 0;

    public int dp(int[] nums, int nowAt, int k) {
        count1++;
        if (nowAt == nums.length - 1) {
            return nums[nowAt];
        }
        if (hasRecorded[nowAt]) {
            count2++;
            return memo[nowAt];
        }
        int maxValueFromNowAt = 0;
        boolean isPut = false;
        for (int j = 1; j <= k; j++) {
            int tmp = 0;
            if (nowAt + j < nums.length) {
                tmp = nums[nowAt] + dp(nums, nowAt + j, k);
                if (isPut) {
                    maxValueFromNowAt = Math.max(maxValueFromNowAt, tmp);
                } else {
                    maxValueFromNowAt = tmp;
                    isPut = true;
                }
            }
        }
        memo[nowAt] = maxValueFromNowAt;
        hasRecorded[nowAt] = true;
        return maxValueFromNowAt;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
//                {new int[]{1}, 2, 1},
//                {new int[]{1, 2}, 2, 3},
//                {new int[]{1, 2, -3}, 2, 0},
//                {new int[]{10, -5, -2, 4, 0, 3}, 3, 17},
//                {new int[]{1, -1, -2, 4, -7, 3}, 2, 7},
                {new int[]{1, -5, -20, 4, -1, 3, -6, -3}, 2, 0},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] nums, int k, int expected) {
        int res = maxResult(nums, k);
//        Assert.assertEquals(res, expected);
        System.out.println(count1);
        System.out.println(count2);
    }
}
