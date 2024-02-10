package Lc.doublepointers;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/minimum-size-subarray-sum/description/">长度最小的子数组</a>
 **/
public class No209_MinSubarrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0, j = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= target) {
                minLen = Math.min(minLen, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));

    }
}
