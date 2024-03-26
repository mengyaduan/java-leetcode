package LcSecond.binarySearch;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 二分查找
 **/
public class BinarySearchBasic {

    /**
     * 左闭右闭的case
     */
    public int binarySearch(int[] nums, int i, int j, int target) {
        int left = i;
        int right = j;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    @DataProvider(name = "units")
    public Object[][] units() {
        return new Object[][]{
                {new int[]{1, 2, 3, 4, 5}, 2, 1},
                {new int[]{1, 2, 3, 4, 5}, 3, 2},
                {new int[]{1, 2, 3, 4, 5}, 5, 4},
                {new int[]{1, 2, 3, 4, 5}, 6, -1},
                {new int[]{1, 2, 3, 4, 5}, 0, -1},
                {new int[]{1, 2, 3, 4}, 0, -1},
                {new int[]{1, 2, 3, 4}, 1, 0},
                {new int[]{1, 2, 3, 4}, 3, 2},
                {new int[]{1, 2, 3, 4}, 4, 3},
                {new int[]{1, 2, 3, 4}, 5, -1},
                {new int[]{1}, 1, 0},
                {new int[]{1}, 0, -1},
                {new int[]{1}, 3, -1},
        };
    }

    @Test(description = "", dataProvider = "units")
    public void test(int[] nums, int target, int index) throws Exception {
        Assert.assertEquals(binarySearch(nums, 0, nums.length - 1, target), index);
    }


}
