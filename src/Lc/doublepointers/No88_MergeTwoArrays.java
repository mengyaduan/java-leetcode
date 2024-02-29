package Lc.doublepointers;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/merge-sorted-array/"</a>
 **/
public class No88_MergeTwoArrays {

    /**
     * 解题思路：因为两个数组都是升序的，所以进行倒排，从nums1的最后一位开始排起来
     * 0. 如果有一个为空，直接返回另一个即可。
     * 1. 两个游标分别指向数据的最后一个有效数字（m-1和n-1）
     * 2. 比游标大小，大的存进nums的最后一个空格，然后空格前移
     * 3. 2中使用的数据的游标，左移，直到有一个为空
     **/

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (k >= 0) {
            int n1 = i < 0 ? Integer.MIN_VALUE : nums1[i];
            int n2 = j < 0 ? Integer.MIN_VALUE : nums2[j];
            if (n1 >= n2) {
                nums1[k--] = n1;
                i--;
            } else {
                nums1[k--] = n2;
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
