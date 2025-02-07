package LcSpring100;

import org.testng.annotations.Test;

import static DataStruct.tools.createMatrix;
import static DataStruct.tools.printIntArray;

public class No189Rotate {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        int[] numsC = new int[nums.length];
        System.arraycopy(nums, 0, numsC, 0, nums.length);
        for (int i = 0; i < nums.length - k; i++) {
            nums[i + k] = numsC[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = numsC[nums.length - k + i];
        }
    }

    private void swapXY(int[] nums, int size, int idx) {

    }

    @Test(description = "")
    public void test123() throws Exception {
        int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6};
        swapXY(nums, 5, 2);
        printIntArray(nums);

    }

    @Test(description = "")
    public void test() throws Exception {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27};
        rotate(nums, 38);

    }
}
