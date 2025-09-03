package LC100Again;


import org.testng.annotations.Test;

public class Lc068 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] helper = new int[m + n];
        int x = 0, y = 0;
        for (int i = 0; i < m + n; i++) {
            if (i > (m + n) / 2) {
                break;
            }
            if (x < m && y < n && nums1[x] <= nums2[y]) {
                helper[i] = nums1[x];
                x++;
            } else if (x < m && y < n) {
                helper[i] = nums2[y];
                y++;
            } else if (x < m) {
                helper[i] = nums1[x];
                x++;
            } else {
                helper[i] = nums2[y];
                y++;
            }
        }
        if ((m + n) % 2 == 0) {
            return (helper[(m + n) / 2 - 1] + helper[(m + n) / 2]) / 2.0;
        } else {
            return helper[(m + n) / 2];
        }
    }

    // FIXME 2025/9/1 还有一个最优解

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{4, 5, 6}));

    }


}
