package LcSpring100;

import org.testng.Assert;
import org.testng.annotations.Test;

import static DataStruct.tools.printIntArray;

public class No493ReversePairs {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }
        // 将列表一拆为2
        int mid = left + (right - left) / 2;
        int a = mergeSort(nums, left, mid);
        int b = mergeSort(nums, mid + 1, right);
        int res = a + b;
        int l1 = left, r1 = mid, l2 = mid + 1, r2 = right;

        int u = l1, v = l2;
        while (u <= r1) {
            while (v <= r2 && (long) nums[u] > 2 * (long) nums[v]) {
                v++;
            }
            // 这里利用了有序数组的特性，从而减少了v的遍历
            res += v - l2;
            u++;
        }
        for (int i = l1; i <= r1; i++) {
            for (int j = l2; j <= r2; j++) {
            }
        }
        // 算完数了，将两个数组合并成一个
        int[] sorted = new int[r2 - l1 + 1];
        int p1 = l1, p2 = l2;
        int p = 0;
        while (p1 <= r1 || p2 <= r2) {
            if (p1 > r1) {
                sorted[p++] = nums[p2++];
            } else if (p2 > r2) {
                sorted[p++] = nums[p1++];
            } else {
                if (nums[p1] <= nums[p2]) {
                    sorted[p++] = nums[p1++];
                } else {
                    sorted[p++] = nums[p2++];
                }
            }
        }
        for (int i = 0; i < sorted.length; i++) {
            nums[l1 + i] = sorted[i];
        }


        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(reversePairs(new int[]{1, 2, 3, 1}), 1);
        Assert.assertEquals(reversePairs(new int[]{9, 8, 6, 7, 2, 4, 3}), 8);
    }


}
