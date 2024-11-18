package Lc;

import org.testng.annotations.Test;

public class No213RobII {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        return Math.max(dp(nums, 0, nums.length - 2), dp(nums, 1, nums.length - 1));
    }

    private int dp(int[] nums, int start, int end) {
        int[][] table = new int[nums.length][2];
        table[start][0] = 0;
        table[start][1] = nums[start];
        for (int i = start + 1; i <= end; i++) {
            table[i][0] = Math.max(table[i - 1][1], table[i - 1][0]);
            table[i][1] = table[i - 1][0] + nums[i];
        }
        return Math.max(table[end][0], table[end][1]);
    }

    @Test(description = "")
    public void test() throws Exception {
//        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{1, 2, 1, 1}));

    }
}
