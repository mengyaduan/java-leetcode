package Lc.sort;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">215：选出第K大的数</a>
 **/
public class No215 {

    public int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length;

        while (start < end) {
            int now = quickSortFindK(nums, start, end);
            for (int item : nums) {
                System.out.print(item + " ");
            }
            System.out.println();
            int count = 0;
            for (int m = now; m < nums.length; m++) {
                if (nums[m] >= nums[now]) {
                    count++;
                }
            }
            if (count == k) {
                return nums[now];
            }
            if (count < k) {
                end = now;
            }
            if (count > k) {
                start = now + 1;
            }
        }
        return nums[k];
    }

    public int quickSortFindK(int[] nums, int start, int end) {
        if (start + 1 >= end) {
            return start;
        }
        int i = start;
        int j = end - 1;
        int key = nums[start];
        while (i < j) {
            while (i < j && nums[j] >= key) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }
            while (i < j && nums[i] <= key) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = key;
        return i;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4, 4},
                {new int[]{1, 1, 1, 1, 1, 2, 1, 1, 1, 3}, 2, 2},
                {new int[]{3}, 1, 3},
                {new int[]{3, 2, 1, 5, 6, 4}, 2, 5},
                {new int[]{2,1}, 2, 1},

        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] nums1, int k, int expected) {
        int res = findKthLargest(nums1, k);
        Assert.assertEquals(res, expected);
    }
}
