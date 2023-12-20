package Lc.binarysearch;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 二分查找插入点
 *
 * @see <a href="https://www.hello-algo.com/chapter_searching/binary_search_insertion/">思路和题解</a>
 **/
public class BinSearchAndInsert {

    public int binarySearchInsertionSimple(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return left;
    }

    @DataProvider(name = "unit")
    public Object[][] unit() {
        return new Object[][]{
                {new int[]{1, 3, 5, 7, 9}, 1, 0},
                {new int[]{1, 3, 5, 7, 9}, 2, 1},
                {new int[]{1, 3, 5, 7, 9}, 6, 3},
                {new int[]{1, 3, 5, 7, 9}, 8, 4},
                {new int[]{1, 3, 5, 7, 9}, 10, 5},
        };
    }

    @Test(description = "", dataProvider = "unit")
    public void testUnit(int[] nums, int target, int expected) throws Exception {
        int result = binarySearchInsertionSimple(nums, target);
        Assert.assertEquals(result, expected);

    }

}
