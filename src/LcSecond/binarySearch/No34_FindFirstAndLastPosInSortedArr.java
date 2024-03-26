package LcSecond.binarySearch;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/">找到数组中的指定区间</a>
 **/
public class No34_FindFirstAndLastPosInSortedArr {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int start = -1, end = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                start = mid;
                r = mid - 1;
            }
        }

        l = 0;
        r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                end = mid;
                l = mid + 1;
            }
        }
        return new int[]{start, end};
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] x = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(x[0] + "," + x[1]);
        x = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        System.out.println(x[0] + "," + x[1]);
        x = searchRange(new int[]{}, 0);
        System.out.println(x[0] + "," + x[1]);
    }
}
