package LcSecond.dynamicprogram;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/jump-game/description/">跳跃游戏</a>
 */
public class No55_JumpGame {

    int[] memo;

    public boolean canJump(int[] nums) {
        memo = new int[nums.length];

        return dp(nums, 0, nums.length - 1);
    }

    public boolean dp(int[] nums, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (nums[start] == 0) {
            return false;
        }
        if (memo[start] == 1) {
            return false;
        }
        int steps = nums[start];
        for (int i = 1; i <= steps; i++) {
            if (dp(nums, start + i, end)) {
                return true;
            }
        }
        memo[start] = 1;
        return false;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(canJump(nums));

        nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }
}
