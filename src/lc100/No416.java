package lc100;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class No416 {

    int[][] memo;

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        memo = new int[nums.length][target + 1];
        return dp(nums, 0, target);
    }

    private boolean dp(int[] nums, int idx, int target) {
        if (idx >= nums.length) {
            return false;
        }
        if (nums[idx] == target) {
            return true;
        }
        if (memo[idx][target] != 0) {
            return memo[idx][target] == 1;
        }
        boolean result = false;
        if (target - nums[idx] >= 0) {
            result |= dp(nums, idx + 1, target - nums[idx]);
        }
        result |= dp(nums, idx + 1, target);
        memo[idx][target] = result ? 1 : 2;
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertFalse(canPartition(new int[]{2, 2, 3, 5}));
        Assert.assertTrue(canPartition(new int[]{1, 5, 11, 5}));
        Assert.assertFalse(canPartition(new int[]{1, 5, 11, 6}));
        Assert.assertFalse(canPartition(new int[]{1, 2, 3, 8}));

    }
}


