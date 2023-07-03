package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/burst-balloons/">戳气球</a>
 **/
public class No312OverLimit {
    HashMap<String, Integer> memo;

    public int maxCoins(int[] nums) {
        memo = new HashMap<>();
        return dp(nums);

    }

    public int dp(int[] nums) {
        String key = "";
        for (int item : nums) {
            key += item + "-";
        }
        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                return nums[0] * nums[1] + nums[0];
            } else {
                return nums[0] * nums[1] + nums[1];
            }
        }
        if (nums.length == 1) {
            return nums[0];
        }

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int max = Integer.MIN_VALUE;
        for (int j = 0; j < nums.length; j++) {
            int a = 1;
            if (j - 1 >= 0) {
                a = nums[j - 1];
            }
            int b = nums[j];
            int c = 1;
            if (j + 1 < nums.length) {
                c = nums[j + 1];
            }
            int[] numsNew = new int[nums.length - 1];
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i == j) {
                    continue;
                }
                numsNew[count] = nums[i];
                count++;
            }
            int res = a * b * c + dp(numsNew);
            max = max > res ? max : res;
        }
        memo.put(key, max);
        return max;
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{1, 5}, 10},
                {new int[]{3, 1, 5, 8}, 167},
                {new int[]{9, 76, 64, 21, 97}, 669494},
                {new int[]{8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2,5}, 3630}

        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] nums, int expected) {
        int res = maxCoins(nums);
        Assert.assertEquals(res, expected);
    }

}
