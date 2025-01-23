package LcSpring100;

import org.testng.annotations.Test;

import static DataStruct.tools.printIntArray;

public class No31NextPermutation {

    public void nextPermutation(int[] nums) {
        // 从后往前找，找到第一个 nums[j] > nums[j-1] 的节点，此时i=j-1
        int j = findTarget(nums, nums.length - 1);
        int i = j - 1;
        if (i >= 0) {
            // 从len-1遍历，找到第一个大于nums[i]的，与i交换
            for (int k = nums.length - 1; k > i; k--) {
                if (nums[k] > nums[i]) {
                    swap(nums, i, k);
                    break;
                }
            }
        }
        //然后将 [j, len-1] 逆序
        reverse(nums, j, nums.length - 1);
        printIntArray(nums);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private int findTarget(int[] nums, int j) {
        while (j >= 1) {
            if (nums[j] > nums[j - 1]) {
                break;
            }
            j--;
        }
        return j;
    }

    @Test(description = "")
    public void test() throws Exception {
//        nextPermutation(new int[]{1, 2, 3, 4});
//        nextPermutation(new int[]{1, 2, 4, 3, 1});
        nextPermutation(new int[]{5, 4, 7, 5, 3, 2});
    }
}
