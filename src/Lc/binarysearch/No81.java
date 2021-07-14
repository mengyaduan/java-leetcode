package Lc.binarysearch;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @see <a href="https://leetcode.com/problems/search-in-rotated-sorted-array-ii/"</a>
 **/
public class No81 {

    /**
     * 解题思路：
     **/

    public boolean search(int[] nums, int target) {
        int len = nums.length;
        if (len == 1) {
            return nums[0] == target;
        }
        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[left]) {
                left++;
                continue;
            }
            boolean isTargetInFirst = isInFirst(nums, left, target);
            boolean isMiddleInFirst = isInFirst(nums, left, nums[mid]);
            if (!(isTargetInFirst ^ isMiddleInFirst)) {
                // 都在前半区 或者 都在后半区
                if (target < nums[mid]) {
                    right = mid;
                } else if (target > nums[mid]) {
                    left = mid;
                } else {
                    return true;
                }
            } else if (isTargetInFirst) {
                // target在前半区，middle在后半区，mid一定小于target，直接缩right
                right = mid;
            } else {
                // target在后半区，middle在前半区，mid一定大于target，直接缩left
                left = mid;
            }
        }
        return false;
    }

    public boolean isInFirst(int[] nums, int index, int target) {
        return target >= nums[index];
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{1}, 1, true},
                {new int[]{2}, 1, false},
                {new int[]{2, 1}, 2, true},
                {new int[]{2, 1}, 3, false},
                {new int[]{2, 3, 4, 5, 6}, 2, true},
                {new int[]{2, 3, 4, 5, 6}, 6, true},
                {new int[]{2, 3, 4, 5, 6}, 7, false},
                {new int[]{2, 5, 6, 0, 0, 1, 2}, 0, true},
                {new int[]{2, 5, 6, 0, 0, 0, 0}, 0, true},
                {new int[]{2, 5, 6, 7, 8, 9, 0}, 0, true},
                {new int[]{2, 2, 2, 2, 2, 2, 2}, 1, false},
                {new int[]{2, 2, 2, 2, 2, 2, 2}, 3, false},
                {new int[]{2, 2, 2, 2, 2, 2, 2}, 2, true},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] nums, int target, boolean expected) {
        String x = Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(","));
        System.out.println(x);
        boolean res = search(nums, target);
        Assert.assertEquals(res, expected);
    }
}
