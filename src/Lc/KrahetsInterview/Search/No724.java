package Lc.KrahetsInterview.Search;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static DataStruct.tools.string2IntArray;

/**
 * @see <a href="https://leetcode.com/problems/find-pivot-index/description/">寻找数组的中心下标</a>
 **/
public class No724 {

    /**
     * 求总和，然后遍历一半即可
     **/
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int leftSide = 0;
        for (int i = 0; i < nums.length; i++) {
            int rest = total - nums[i];
            if (rest % 2 == 0 && rest / 2 == leftSide) {
                return i;
            }
            leftSide += nums[i];
        }
        return -1;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                {"1, 7, 3, 6, 5, 6", 3},
                {"1, 2, 3", -1},
                {"2,1,-1", 0},
                {"-1,-1,-1,-1,-1,-1", -1},
                {"-1,-1,-1,-1,-1,0", 2},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, int expected) {
        int[] nums = string2IntArray(s);
        int res = pivotIndex(nums);
        Assert.assertEquals(res, expected);

    }

}

