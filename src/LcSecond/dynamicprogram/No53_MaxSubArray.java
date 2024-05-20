package LcSecond.dynamicprogram;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/maximum-subarray/description/">最长连续子串</a>
 */
public class No53_MaxSubArray {
    public int maxSubArray(int[] nums) {
        int resMax = nums[0];
        int lastLong = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int nowAt = Math.max(nums[i], nums[i] + lastLong);
            lastLong = nowAt;
            resMax = Math.max(resMax, nowAt);
        }
        return resMax;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
