package Lc.binarysearch;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/">154:找到旋转数组中的最小值</a>
 **/
public class No154 {

    /**
     * 解题思路：
     **/

    public int findMin(int[] nums) {
        int len = nums.length;
//        if (len == 1) {
//            return nums[0];
//        }
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

    /**
     * 判定左边界收缩，还是右边界收缩
     **/
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
                {new int[]{1, 1, 1, 2, 1}, 1},

        };
        return data;
    }

    public int findMinAnswer(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else if (nums[pivot] > nums[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return nums[low];
    }

    public int findMin2(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] > nums[low]) {
                low = pivot;
            } else if (nums[pivot] < nums[low]) {
                high = pivot - 1;
            } else {
                low += 1;
            }
        }
        return nums[low];
    }


    // 测试点

    /**
     * 1. 只有一个元素
     * 2. 已经是升序的了
     * 3. 最右边一个是min
     * 4. 所有一样大
     * 5. 二分法中间值的左右一边大，需要判定是往左还是往右
     **/

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] nums, int expected) {
        int res = findMinAnswer(nums);
        Assert.assertEquals(res, expected);
    }
}
