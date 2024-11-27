package lc100;

import org.testng.Assert;
import org.testng.annotations.Test;

public class No55 {


    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightBound = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightBound) {
                rightBound = Math.max(rightBound, i + nums[i]);
            }
            if (rightBound >= n - 1) {
                return true;
            }
        }
        return false;
    }

    int[] helper;

    public boolean canJumpComplex(int[] nums) {
        helper = new int[nums.length];
        return func(nums, 0);
    }


    public boolean func(int[] nums, int idx) {
        if (idx == nums.length - 1) {
            return true;
        }
        if (idx >= nums.length) {
            // 超长、为0，均直接返回
            return false;
        }
        if (nums[idx] == 0) {
            // 如果停在0，标记
            helper[idx] = 2;
        }
        if (helper[idx] != 0) {
            return helper[idx] == 1;
        }
        boolean res = false;
        for (int i = 1; i <= nums[idx]; i++) {
            res |= func(nums, idx + i);
            if (res) {
                helper[idx] = 1;
                return res;
            }
        }
        helper[idx] = res ? 1 : 2;
        return res;
    }


    @Test(description = "")
    public void test() throws Exception {
        Assert.assertTrue(canJump(new int[]{2, 0}));
        Assert.assertTrue(canJump(new int[]{2, 3, 1, 1, 4}));
        Assert.assertFalse(canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
