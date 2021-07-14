package Lc.binarysearch;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/"</a>
 **/
public class No154 {

    /**
     * 解题思路：
     **/

    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int left = 0;
        int right = len - 1;
        // 已经升序了，直接返回最左
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        int result = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < result) {
                result = nums[mid];
            }
            if (nums[mid] == nums[left]) {
                left++;
                if (left <= right && nums[left] < nums[right]) {
                    return nums[left];
                }
                continue;
            }
            boolean isNowInFirst = isInFirst(nums, left, nums[mid]);
            if (isNowInFirst) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return result;
    }

    public boolean isInFirst(int[] nums, int index, int target) {
        return target >= nums[index];
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{1}, 1},
                {new int[]{2}, 2},
                {new int[]{2, 1}, 1},
                {new int[]{2, 3, 4, 5, 6}, 2},
                {new int[]{2, 5, 6, 0, 0, 1, 2}, 0},
                {new int[]{2, 5, 6, 0, 0, 0, 0}, 0},
                {new int[]{2, 5, 6, 7, 8, 9, 0}, 0},
                {new int[]{2, 2, 2, 2, 2, 2, 2}, 2},
                {new int[]{10, 1, 10, 10, 10}, 1},

        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] nums, int expected) {
        int res = findMin(nums);
        Assert.assertEquals(res, expected);
    }
}
