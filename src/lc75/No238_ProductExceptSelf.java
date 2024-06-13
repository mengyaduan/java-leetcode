package lc75;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/product-of-array-except-self/?envType=study-plan-v2&envId=leetcode-75">除自身以外数组的乘积</a>
 */
public class No238_ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] left2right = new int[nums.length];
        left2right[0] = nums[0];
        int[] right2left = new int[nums.length];
        right2left[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            left2right[i] = nums[i] * left2right[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            right2left[i] = nums[i] * right2left[i + 1];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            int left = 1, right = 1;
            if (i - 1 >= 0) {
                left = left2right[i - 1];
            }
            if (i + 1 < nums.length) {
                right = right2left[i + 1];
            }
            res[i] = left * right;
        }

        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] nums = new int[]{0, 0};
        int[] x = productExceptSelf(nums);
        System.out.println("");

    }
}
