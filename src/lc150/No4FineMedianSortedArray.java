package lc150;

public class No4FineMedianSortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        boolean needTwo = false;
        if ((m + n) % 2 == 0) {
            //如果是偶数，需要找两个，否则找一个
            needTwo = true;
        }
        int i = 0, j = 0;
        int cnt = 0, target = (m + n - 1) / 2;
        while (cnt < target) {
            if (i < m && j < n) {
                if (nums1[i] <= nums2[j]) {
                    i++;
                } else {
                    j++;
                }
            } else if (i < m) {
                i++;
            } else {
                j++;
            }
            cnt++;
        }
        int a, b;
        if (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                a = nums1[i];
                b = needTwo ? (i + 1 < m ? (Math.min(nums1[i + 1], nums2[j])) : nums2[j]) : 0;
            } else {
                a = nums2[j];
                b = needTwo ? (j + 1 < n ? (Math.min(nums1[i], nums2[j + 1])) : nums1[i]) : 0;
            }
        } else if (i < m) {
            // nums2已经用完了
            a = nums1[i];
            // 有越界的情况，需要判断一下是不是需要b
            b = needTwo ? nums1[i + 1] : 0;
        } else {
            a = nums2[j];
            b = needTwo ? nums2[j + 1] : 0;
        }
        return needTwo ? ((a + b) / 2.0) : a;
    }
}
