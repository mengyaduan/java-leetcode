package lc150;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No88Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        // 指向当前位置
        int last = nums1.length - 1;
        int i = m - 1;
        int j = n - 1;
        while (last >= 0) {
            int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE;
            if (i >= 0) {
                a = nums1[i];
            }
            if (j >= 0) {
                b = nums2[j];
            }
            if (a > b) {
                nums1[last] = a;
                last--;
                i--;
            } else {
                nums1[last] = b;
                last--;
                j--;
            }
        }
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3, new int[]{1, 2, 2, 3, 5, 6}},
                {new int[]{1}, 1, new int[]{}, 0, new int[]{1}},
                {new int[]{0, 0}, 0, new int[]{1, 2}, 2, new int[]{1, 2}},
                {new int[]{2, 0}, 1, new int[]{1}, 1, new int[]{1, 2}},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] nums1, int m, int[] nums2, int n, int[] res) throws Exception {
        merge(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i++) {
            Assert.assertEquals(nums1[i], res[i]);
        }
    }
}
