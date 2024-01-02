package Lc.KrahetsInterview.DoublePointers;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/">两数之和：输入有序数组</a>
 **/
public class No167 {


    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                break;
            }
        }
        return new int[]{i + 1, j + 1};
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                //
                {new int[]{2, 3, 4}, 6, new int[]{1, 3}},
                {new int[]{2, 7, 11, 15}, 9, new int[]{1, 2}},

        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] numbers, int target, int[] expected) {
        int[] res = twoSum(numbers, target);
        Assert.assertEquals(res[0], expected[0]);
        Assert.assertEquals(res[1], expected[1]);
    }

}

