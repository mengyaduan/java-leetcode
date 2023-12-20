package Lc.sort;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class QuickSort {


    /**
     * 左闭右闭
     *
     * @param nums
     * @param start
     * @param end
     */
    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int pivot = nums[i];

        while (i < j) {
            // 先从右往左找到第一个小于pivot的数
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            // 把这个数填进nums[i]里面
            nums[i] = nums[j];
            // 从左往右，找到第一个大于pivot的数
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            // 把这个数填进nums[j]的缺口
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        quickSort(nums, start, i - 1);
        quickSort(nums, i + 1, end);
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{2, 0, 2, 1, 1, 0}, new int[]{0, 0, 1, 1, 2, 2}},
                {new int[]{2, 0, 1}, new int[]{0, 1, 2}},
                {new int[]{0}, new int[]{0}},
                {new int[]{1}, new int[]{1}},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] input, int[] expected) {
        quickSort(input, 0, input.length - 1);
        for (int i = 0; i < input.length; i++) {
            Assert.assertEquals(input[i], expected[i]);
        }
    }
}
