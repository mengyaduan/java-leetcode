package lc100;

import org.testng.annotations.Test;

public class No4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] nums = new int[m + n];
        int cur1 = 0, cur2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cur1 >= m) {
                nums[i] = nums2[cur2];
                cur2++;
                continue;
            } else if (cur2 >= n) {
                nums[i] = nums1[cur1];
                cur1++;
                continue;
            }
            if (nums1[cur1] <= nums2[cur2]) {
                nums[i] = nums1[cur1];
                cur1++;
            } else {
                nums[i] = nums2[cur2];
                cur2++;
            }
        }
        if ((m + n) % 2 != 0) {
            // 奇数
            return nums[(m + n - 1) / 2];
        } else {
            int x = (m + n - 1) / 2;
            return (nums[x] + nums[x + 1]) / 2.0;
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}));

    }
}
