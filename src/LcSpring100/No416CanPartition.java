package LcSpring100;

import org.testng.annotations.Test;

public class No416CanPartition {

    int[][] helper;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        helper = new int[nums.length][target + 1];
        return canP(nums, 0, target);
    }

    private boolean canP(int[] nums, int i, int target) {
        if (i >= nums.length) {
            return false;
        }
        if (target == nums[i]) {
            return true;
        }
        if (helper[i][target] != 0) {
            return helper[i][target] == 1;
        }
        // 当前值选取
        boolean a = target > nums[i] && canP(nums, i + 1, target - nums[i]);
        // 当前值跳过
        boolean b = canP(nums, i + 1, target);
        helper[i][target] = (a || b ? 1 : -1);
        return a || b;
    }

    @Test(description = "")
    public void test123() throws Exception {
        System.out.println(canPartition(new int[]{1, 5, 5, 4, 7}));
        System.out.println(canPartition(new int[]{1, 5, 5, 4, 8}));
        System.out.println(canPartition(new int[]{5, 7, 3, 7}));

    }

}
