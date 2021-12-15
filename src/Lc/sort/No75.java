package Lc.sort;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/sort-colors/">no75 快排问题</a>
 **/
public class No75 {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length);
    }

    public void quickSort(int[] nums, int left, int right) {
        if (nums.length == 1 || left >= right) {
            return;
        }
        int l = left;
        int r = right - 1;
        int flag = nums[l];
        while (l < r) {
            while (l < r && flag <= nums[r]) {
                r--;
            }
            if (l < r && flag > nums[r]) {
                nums[l] = nums[r];
                l++;
            }
            while (l < r && nums[l] <= flag) {
                l++;
            }
            if (l < r && nums[l] > flag) {
                nums[r] = nums[l];
                r--;
            }
            nums[l] = flag;
        }
        quickSort(nums, left, l);
        quickSort(nums, l + 1, right);
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{2, 0, 2, 1, 1, 0}, new int[]{0, 0, 1, 1, 2, 2}},
                {new int[]{2, 0, 1}, new int[]{0, 1, 2}},
                {new int[]{0}, new int[]{0}},
                {new int[]{1}, new int[]{1}},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] input, int[] expected) {
        sortColors(input);
        for (int i = 0; i < input.length; i++) {
            Assert.assertEquals(input[i], expected[i]);
        }
    }
}
