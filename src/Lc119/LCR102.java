package Lc119;

import org.testng.annotations.Test;

import java.util.Arrays;

public class LCR102 {

    public int findTargetSumWays(int[] nums, int target) {
        int[][] memo = new int[nums.length][20 * 1000 * 2];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return dp(nums, nums.length - 1, target, memo);
    }


    /**
     * 从0到r（含）能够生成和为target的个数
     * dp(r,target) = dp(r-1 , target-nums[r]) + dp(r-1, target+nums[r])
     */
    public int dp(int[] nums, int r, int target, int[][] memo) {
        if (r == 0) {
            if (nums[r] == target && target == 0) {
                return 2;
            } else if (nums[r] == target || nums[r] == -target) {
                return 1;
            } else {
                return 0;
            }
        }
        if (memo[r][target + 20000] != Integer.MAX_VALUE) {
            return memo[r][target + 20000];
        }

        int res = dp(nums, r - 1, target - nums[r], memo) + dp(nums, r - 1, target + nums[r], memo);
        memo[r][target + 20000] = res;
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1));

    }
}
