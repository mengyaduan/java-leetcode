package lc100;

import org.testng.annotations.Test;

import static DataStruct.tools.printIntArray;

public class No238 {

    public int[] productExceptSelf(int[] nums) {
        int[] l2r = new int[nums.length];
        int[] r2l = new int[nums.length];
        int left = 1, right = 1;
        for (int i = 0; i < nums.length; i++) {
            l2r[i] = left * nums[i];
            left = l2r[i];

            int idxR = nums.length - 1 - i;
            r2l[idxR] = right * nums[idxR];
            right = r2l[idxR];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int a = i > 0 ? l2r[i - 1] : 1;
            int b = i < nums.length - 1 ? r2l[i + 1] : 1;
            result[i] = a * b;
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        printIntArray(productExceptSelf(new int[]{1, 2, 3, 4}));
    }
}
