package Lc119;

import com.sun.org.apache.xerces.internal.impl.XMLEntityManager;

import java.util.Arrays;

public class LCR101 {

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int[][] memo = new int[nums.length][30000];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(nums, 0, target, 0, memo);
    }

    private boolean dp(int[] nums, int idx, int target, int cur, int[][] memo) {
        if (cur == target) {
            return true;
        }
        if (cur > target || idx >= nums.length) {
            return false;
        }
        if (memo[idx][cur] != -1) {
            return memo[idx][cur] == 1;
        }
        boolean res = false;
        // 选择第i个
        res |= dp(nums, idx + 1, target, cur + nums[idx], memo);
        // 不选择第i个
        res |= dp(nums, idx + 1, target, cur, memo);
        memo[idx][cur] = res ? 1 : 2;
        return res;
    }

}
