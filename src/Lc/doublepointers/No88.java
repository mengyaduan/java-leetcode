package Lc.doublepointers;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/merge-sorted-array/"</a>
 **/
public class No88 {

    /**
     * 解题思路：因为两个数组都是升序的，所以进行倒排，从nums1的最后一位开始排起来
     * 0. 如果有一个为空，直接返回另一个即可。
     * 1. 两个游标分别指向数据的最后一个有效数字（m-1和n-1）
     * 2. 比游标大小，大的存进nums的最后一个空格，然后空格前移
     * 3. 2中使用的数据的游标，左移，直到有一个为空
     **/

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
        }
        int target = nums1.length - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[target] = nums1[p1];
                p1--;
            } else {
                nums1[target] = nums2[p2];
                p2--;
            }
            target--;
        }
        while (p2 >= 0) {
            nums1[target] = nums2[p2];
            target--;
            p2--;
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
