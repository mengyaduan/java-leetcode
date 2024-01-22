package Lc.KrahetsInterview.DynamicProgram;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/running-sum-of-1d-array/description/">一维数组的动态和</a>
 **/
public class No1480 {

    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            res[i] = sum + nums[i];
            sum = res[i];
        }
        return res;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                //
                {new int[]{1, 2, 3, 4}, new int[]{1, 3, 6, 10}},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] nums, int[] expected) {
        int[] res = runningSum(nums);
        for (int i = 0; i < res.length; i++) {
            Assert.assertEquals(res[i], expected[i]);
        }

    }

}

