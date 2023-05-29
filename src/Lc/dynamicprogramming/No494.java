package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/target-sum/">目标和</a>
 **/
public class No494 {
    HashMap<String, Integer> memo = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        return dp(nums, 0, target);
    }

    public int dp(int[] nums, int i, int target) {
        if (i == nums.length) {
            return target == 0 ? 1 : 0;
        }
        String key = i + "_" + target;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int x = dp(nums, i + 1, target - nums[i]) + dp(nums, i + 1, target + nums[i]);
        memo.put(key, x);
        return x;
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{1}, 1, 1},
                {new int[]{1, 1}, 0, 2},
                {new int[]{1, 1, 1}, 1, 3},
                {new int[]{1, 1, 1, 1, 1}, 3, 5},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] m, int target, int expected) {
        memo.clear();
        int res = findTargetSumWays(m, target);
        Assert.assertEquals(res, expected);
    }

}
