package Lc.KrahetsInterview.DynamicProgram;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/house-robber-ii/">打家劫舍 ii</a>
 **/
public class No213 {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (nums.length == 3) {
            int x = Math.max(nums[0], nums[1]);
            return Math.max(x, nums[2]);
        }
        // 先计算0到n-2的最大值
        int x = robDp(nums, 0, nums.length - 2);
        // 先计算1到n-1的最大值
        int y = robDp(nums, 1, nums.length - 1);
        return Math.max(x, y);
    }

    public int robDp(int[] nums, int start, int end) {
        int[][] memo = new int[end - start + 1][2];
        memo[0][0] = 0;
        memo[0][1] = nums[start];
        int res = memo[0][1];
        for (int i = 1; i < memo.length; i++) {
            memo[i][0] = Math.max(memo[i - 1][0], memo[i - 1][1]);
            memo[i][1] = memo[i - 1][0] + nums[start + i];
            res = Math.max(res, memo[i][1]);
        }
        return res;
    }


    @Test(description = "")
    public void test() throws Exception {
        System.out.println(rob(new int[]{1, 2, 1, 1}));

    }

}