package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/maximum-subarray/">最大子数组</a>
 **/
public class No53 {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        memo[0] = nums[0];
        int maxRes = memo[0];
        for (int i = 1; i < n; i++) {
            memo[i] = memo[i - 1] < 0 ? nums[i] : memo[i - 1] + nums[i];
            maxRes = maxRes > memo[i] ? maxRes : memo[i];
        }
        return maxRes;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{5, 4, -1, 7, 8}, 23},
                {new int[]{1}, 1},
                {new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] m, int expected) {
        int res = maxSubArray(m);
        Assert.assertEquals(res, expected);
    }

}
