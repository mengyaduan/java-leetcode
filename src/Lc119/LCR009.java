package Lc119;

import org.testng.annotations.Test;

import java.util.ArrayList;

public class LCR009 {


    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;
        if (k <= 1) {
            return result;
        }
        int left = 0, prod = 1;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left++];
            }
            result += right - left + 1;
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        // 10 50 100 600
        // 600 60 12 6


    }
}
