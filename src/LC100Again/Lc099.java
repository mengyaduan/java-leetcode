package LC100Again;


import org.testng.annotations.Test;

import static DataStruct.tools.printIntArray;

public class Lc099 {
    // 1,2,3,8,7,6,5,4

    public void nextPermutation(int[] nums) {
        int secondPart = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                // 找到第一个逆序坐标
                secondPart = i;
                break;
            }
        }
        // 从secondPart往后，直接翻转
        reverse(nums, secondPart, nums.length - 1);
        // 如果secondPart前面没有值，直接返回；如果有值，从secondPart开始遍历，找到第一个比该值大的，兑换
        if (secondPart > 0) {
            int temp = nums[secondPart - 1];
            for (int i = secondPart; i < nums.length; i++) {
                if (nums[i] > temp) {
                    nums[secondPart - 1] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
        }
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] nums = new int[]{1, 2, 5, 3, 4};
        nextPermutation(nums);
        printIntArray(nums);
        nums = new int[]{1, 2, 5, 4, 3};
        nextPermutation(nums);
        printIntArray(nums);
        nums = new int[]{3, 2, 1};
        nextPermutation(nums);
        printIntArray(nums);
        nums = new int[]{1, 1, 4};
        nextPermutation(nums);
        printIntArray(nums);
        nums = new int[]{1, 4, 4};
        nextPermutation(nums);
        printIntArray(nums);

    }

}
