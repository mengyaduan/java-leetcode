package lc75;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/find-pivot-index/description/?envType=study-plan-v2&envId=leetcode-75">数组中心下标</a>
 */
public class No724_pivotIndex {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int total = sum[n - 1];
        int res = -1;
        int leftSide = 0;
        for (int i = 0; i < n; i++) {
            if (total - nums[i] - leftSide == leftSide) {
                return i;
            }
            leftSide = sum[i];
        }
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(pivotIndex(new int[]{1, 2, 3}));
        System.out.println(pivotIndex(new int[]{2, 1, -1}));
        System.out.println(pivotIndex(new int[]{1, -1, 2}));
        System.out.println(pivotIndex(new int[]{1, 1, 1, -1, -1, -1}));

    }
}
