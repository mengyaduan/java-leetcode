package Lc.binarysearch;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/">4:两个有序数据，求merge后的中间值</a>
 **/
public class No4 {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int mid = (m + n) / 2;
        int[] merged = new int[mid + 1];
        boolean isOdd = (m + n) % 2 == 1;
        int l = 0;
        int r = 0;
        int flag = 0;
        while (flag < merged.length) {
            if (l < m && r < n) {
                if (nums1[l] < nums2[r]) {
                    merged[flag] = nums1[l];
                    l++;
                } else {
                    merged[flag] = nums2[r];
                    r++;
                }
            } else if (l < m) {
                merged[mid] = nums1[l + mid - flag];
                if (mid - 1 >= flag) {
                    merged[mid - 1] = nums1[l + mid - flag - 1];
                }
                break;
            } else if (r < n) {
                merged[mid] = nums2[r + mid - flag];
                if (mid - 1 >= flag) {
                    merged[mid - 1] = nums2[r + mid - flag - 1];
                }
                break;
            }
            flag++;
        }
        if (isOdd) {
            return merged[mid];
        } else {
            return (merged[mid] + merged[mid - 1]) / 2.0;
        }
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{1}, new int[]{2, 3, 4}, 2.50},
                {new int[]{1, 2}, new int[]{3, 4, 5}, 3.00},
                {new int[]{}, new int[]{2, 3}, 2.5},
                {new int[]{1, 2}, new int[]{3, 4}, 2.5},
                {new int[]{}, new int[]{1}, 1},
                {new int[]{0, 0}, new int[]{0, 0}, 0},
                {new int[]{2}, new int[]{}, 2},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] nums1, int[] nums2, double expected) {
        double res = findMedianSortedArrays(nums1, nums2);
        Assert.assertEquals(res, expected);
    }
}
