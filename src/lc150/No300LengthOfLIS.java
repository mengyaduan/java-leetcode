package lc150;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/longest-increasing-subsequence/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No300LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int res = 1;
        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            int len = memo[i];
            res = Math.max(res, len);
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > target) {
                    memo[j] = Math.max(memo[j], len + 1);
                }
                res = Math.max(res, memo[j]);
            }
        }
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}), 4);
        Assert.assertEquals(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}), 4);
        Assert.assertEquals(lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}), 1);

    }
}
