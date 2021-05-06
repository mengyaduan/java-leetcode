package Lc.doublepointers;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/"</a>
 **/
public class No167 {

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int expected = target - numbers[left];
            if (numbers[right] > expected) {
                right--;
            } else if (numbers[right] < expected) {
                left++;
            } else {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            }

        }
        return res;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{2, 7, 11, 15}, 9, new int[]{1, 2}},
                {new int[]{2, 3, 4}, 6, new int[]{1, 3}},
                {new int[]{-1, 0}, -1, new int[]{1, 2}},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] numbers, int target, int[] res) throws Exception {
        int[] result = twoSum(numbers, target);
        for (int i = 0; i < result.length; i++) {
            Assert.assertEquals(result[i], res[i]);
        }
    }
}
