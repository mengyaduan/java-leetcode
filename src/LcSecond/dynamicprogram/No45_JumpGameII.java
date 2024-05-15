package LcSecond.dynamicprogram;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/jump-game-ii/description/">跳跃游戏2</a>
 */
public class No45_JumpGameII {

    int[] memo;

    public int jump(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums, 0, nums.length - 1);
    }

    public int dp(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        if (nums[start] == 0) {
            // 没到终点，但是此路不通
            return Integer.MAX_VALUE;
        }
        if (memo[start] != -1) {
            return memo[start];
        }
        int steps = nums[start];
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= steps; i++) {
            int nextMove = dp(nums, start + i, end);
            if (nextMove != Integer.MAX_VALUE) {
                res = Math.min(res, nextMove + 1);
            }
        }
        memo[start] = res;
        return memo[start];
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        int[] nums2 = new int[]{2, 3, 0, 0, 4};
        Assert.assertEquals(jump(nums), 2);
        Assert.assertEquals(jump(nums2), 2);
    }

    @Test(description = "")
    public void test123() throws Exception {
        int[] nums = new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0};
        System.out.println(jump(nums));

    }
}
