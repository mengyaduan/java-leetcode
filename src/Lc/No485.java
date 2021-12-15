package Lc;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/max-consecutive-ones/">485:从01数组中找到最长连续的1</a>
 **/
public class No485 {
    /**
     * 思路：状态机，00，01，10，11四种情况，进行四种操作
     * 00:continue
     * 01:count++
     * 11:count++
     * 10:maxLen=count;count=0
     **/
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLen = 0;
        int count = nums[0] == 0 ? 0 : 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == 0 && nums[i] == 0) {
                continue;
            }
            if (nums[i - 1] == 0 && nums[i] == 1) {
                count++;
            }
            if (nums[i - 1] == 1 && nums[i] == 1) {
                count++;
            }
            if (nums[i - 1] == 1 && nums[i] == 0) {
                if (count > maxLen) {
                    maxLen = count;
                }
                count = 0;
            }
        }
        if (count > maxLen) {
            return count;
        }
        return maxLen;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{1, 0, 1, 1, 0, 1}, 2},
                {new int[]{1, 1, 0, 1}, 2},
                {new int[]{1, 1, 0, 1, 1, 1}, 3},
                {new int[]{1}, 1},
                {new int[]{0}, 0},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] nums, int expected) {
        int res = findMaxConsecutiveOnes(nums);
        Assert.assertEquals(res, expected);
    }
}
