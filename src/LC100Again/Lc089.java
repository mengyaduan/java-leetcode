package LC100Again;


import org.testng.annotations.Test;

public class Lc089 {

    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int item : nums) {
            total += item;
        }
        if (total % 2 != 0) {
            return false;
        }
        int target = total / 2;
        int[][] memo = new int[nums.length][target + 1];
        return dp(nums, 0, target, memo);
    }

    private boolean dp(int[] nums, int i, int target, int[][] memo) {
        if (target == 0) {
            return true;
        }
        if (i >= nums.length) {
            return false;
        }
        if (memo[i][target] != 0) {
            return memo[i][target] == 1;
        }
        boolean res = dp(nums, i + 1, target, memo) || dp(nums, i + 1, target - nums[i], memo);
        memo[i][target] = res ? 1 : 2;
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(canPartition(new int[]{1, 2, 3, 5}));

    }


}
