package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/predict-the-winner/">博弈问题</a>
 **/
public class No486 {


    HashMap<String, int[]> memo = new HashMap<>();

    public boolean PredictTheWinner(int[] nums) {
        memo.clear();
        int[] res = getScore(nums, 0, nums.length - 1);
        return res[0] >= res[1];
    }

    public int[] getScore(int[] nums, int i, int j) {
        String key = String.format("%d_%d", i, j);
        int[] res = new int[2];
        if (i == j) {
            res[0] = nums[i];
            res[1] = 0;
            memo.put(key, res);
            return res;
        }
        if (i + 1 == j) {
            res[0] = nums[i];
            res[1] = nums[j];
            if (nums[i] < nums[j]) {
                res[0] = nums[j];
                res[1] = nums[i];
            }
            memo.put(key, res);
            return res;
        }

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int pickLeftX = nums[i] + getScore(nums, i + 1, j)[1];
        int pickLeftY = getScore(nums, i + 1, j)[0];

        int pickRightX = nums[j] + getScore(nums, i, j - 1)[1];
        int pickRightY = getScore(nums, i, j - 1)[0];

        if (pickLeftX >= pickRightX) {
            res[0] = pickLeftX;
            res[1] = pickLeftY;
        } else {
            res[0] = pickRightX;
            res[1] = pickRightY;
        }
        memo.put(key, res);

        return res;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{1, 5, 233, 7}, true},
                {new int[]{1, 5, 2}, false},
                {new int[]{1, 5}, true},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] nums, boolean expected) {
        boolean res = PredictTheWinner(nums);
        Assert.assertEquals(res, expected);
    }

}
