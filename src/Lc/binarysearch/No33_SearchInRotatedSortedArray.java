package Lc.binarysearch;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/search-in-rotated-sorted-array/">旋转升序数组查找</a>
 **/
public class No33_SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (mid == i) {
                i = mid + 1;
                continue;
            } else if (mid == j) {
                j = mid - 1;
                continue;
            }
            if (nums[mid] > nums[i]) {
                // i to mid，升序
                if (target > nums[mid] || target < nums[i]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            } else {
                // mid to j升序
                if (target > nums[j] || target < nums[mid]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
        }
        return nums[i] == target ? i : -1;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(search(new int[]{3, 1}, 1), 1);
        Assert.assertEquals(search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8), 4);
        Assert.assertEquals(search(new int[]{3, 1}, 4), -1);
        Assert.assertEquals(search(new int[]{3, 1}, 0), -1);
        Assert.assertEquals(search(new int[]{1}, 0), -1);
        Assert.assertEquals(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7), 3);
        Assert.assertEquals(search(new int[]{4, 5, 0, 1, 2}, 3), -1);
        Assert.assertEquals(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4), 0);
        Assert.assertEquals(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5), 1);
        Assert.assertEquals(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2), 6);
    }
}

