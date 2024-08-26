package lc150;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/maximum-sum-circular-subarray/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No918MaxSubarraySumCircular {


    public int maxSubarraySumCircular(int[] nums) {
        int res = Integer.MIN_VALUE;
        int total = 0;
        int curMax = 0, curMin = 0;
        int sumMax = Integer.MIN_VALUE;
        int sumMin = Integer.MAX_VALUE;
        for (int num : nums) {
            total += num;
            curMax = Math.max(num, curMax + num);
            curMin = Math.min(num, curMin + num);
            sumMax = Math.max(sumMax, curMax);
            sumMin = Math.min(sumMin, curMin);
        }
        if (sumMax < 0) {
            return sumMax;
        }
        return Math.max(sumMax, total - sumMin);
    }


    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(maxSubarraySumCircular(new int[]{9, -4, -7, 29, -18}), 29);
        Assert.assertEquals(maxSubarraySumCircular(new int[]{9, -4, -7, 29, -18}), 29);
        Assert.assertEquals(maxSubarraySumCircular(new int[]{29, -4, -7, 9, -18}), 29);
        Assert.assertEquals(maxSubarraySumCircular(new int[]{9, -4, -7, 9}), 18);
        Assert.assertEquals(maxSubarraySumCircular(new int[]{4, 4, -9, 2, 1, 7, 5}), 23);
        Assert.assertEquals(maxSubarraySumCircular(new int[]{1, -5, 12, -3, 7}), 17);
        Assert.assertEquals(maxSubarraySumCircular(new int[]{1, 12, -3, 7}), 20);
        Assert.assertEquals(maxSubarraySumCircular(new int[]{5, -3, 5}), 10);
        Assert.assertEquals(maxSubarraySumCircular(new int[]{-3, -2, -3}), -2);
        Assert.assertEquals(maxSubarraySumCircular(new int[]{ -2}), -2);
        Assert.assertEquals(maxSubarraySumCircular(new int[]{ 2}), 2);

    }
}
