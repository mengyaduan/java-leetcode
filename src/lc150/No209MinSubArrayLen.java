package lc150;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No209MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int len = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= target) {
                len = Math.min(len, i - left + 1);
                sum -= nums[left];
                sum -= nums[i];
                left++;
                i--;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}), 3);
        Assert.assertEquals(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}), 2);
        Assert.assertEquals(minSubArrayLen(4, new int[]{1, 4, 4}), 1);
        Assert.assertEquals(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}), 0);
    }
}
