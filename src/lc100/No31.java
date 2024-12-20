package lc100;

import org.testng.annotations.Test;

import java.util.Arrays;

import static DataStruct.tools.printIntArray;

public class No31 {
    public void nextPermutation(int[] nums) {
        // 从后往前找，找到第一个nums[i-1] < nums[i]的，然后交换
        int j = nums.length - 1;
        for (; j > 0; j--) {
            if (nums[j - 1] < nums[j]) {
                break;
            }
        }
        if (j == 0) {
            // 整个数组是倒排的，此时直接倒序输出就行了
            int l = 0, r = nums.length - 1;
            int temp = 0;
            while (l < r) {
                temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
            return;
        }
        // 检查j到n-1之间，找到比nums[j-1]大的最接近的数字的坐标idx
        int idx = j;
        int delta = Integer.MAX_VALUE;
        int toBeUp = nums[j - 1];
        for (int i = j; i < nums.length; i++) {
            if (nums[i] > toBeUp && nums[i] - toBeUp < delta) {
                delta = nums[i] - nums[j - 1];
                idx = i;
            }
        }
        // 交换idx和j-1
        int temp = nums[idx];
        nums[idx] = nums[j - 1];
        nums[j - 1] = temp;
        // 将[j, n-1]重新排序
        Arrays.sort(nums, j, nums.length);
    }

    @Test(description = "")
    public void test() throws Exception {
        nextPermutation(new int[]{1, 2, 3, 4});
        nextPermutation(new int[]{2, 3, 1, 4});
        nextPermutation(new int[]{3, 4, 1, 2});
        nextPermutation(new int[]{4, 3, 2, 1});
        nextPermutation(new int[]{2, 4, 3, 1});
        nextPermutation(new int[]{1, 1, 5});


    }
}
