package lc75;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/increasing-triplet-subsequence/description/?envType=study-plan-v2&envId=leetcode-75">递增的三元子序列</a>
 */
public class No334_increasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] from = new int[n];
        from[0] = Integer.MAX_VALUE;
        int[] to = new int[n];
        to[n - 1] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            // 从左到右，记录每个值左边最小值
            from[i] = Math.min(nums[i - 1], from[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            to[i] = Math.max(nums[i + 1], to[i + 1]);
            if (from[i] < nums[i] && nums[i] < to[i]) {
                return true;
            }
        }
        return false;
    }

    @DataProvider(name = "unit")
    public Object[][] unit() {
        return new Object[][]{
                {new int[]{1, 2, 3, 4, 5}, true},
                {new int[]{5, 4, 3, 2, 1}, false},
                {new int[]{2, 1, 5, 0, 4, 6}, true},
        };
    }

    @Test(description = "", dataProvider = "unit")
    public void test(int[] nums, boolean res) throws Exception {
        Assert.assertEquals(increasingTriplet(nums), res);

    }
}
