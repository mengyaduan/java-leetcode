package Lc.KrahetsInterview.Math;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=selected-coding-interview">除自身以外的乘法</a>
 **/
public class No238_ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] left2right = new int[nums.length];
        int[] right2left = new int[nums.length];

        left2right[0] = 1;
        right2left[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left2right[i] = nums[i - 1] * left2right[i - 1];
            right2left[nums.length - 1 - i] = nums[nums.length - 1 - (i - 1)] * right2left[nums.length - 1 - (i - 1)];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = left2right[i] * right2left[i];
        }
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        productExceptSelf(new int[]{1, 2, 3, 4});
    }
}

