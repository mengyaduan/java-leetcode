package LC100Again;


import org.testng.annotations.Test;

import java.util.Arrays;

public class Lc079 {

    public int jump(int[] nums) {
        int n = nums.length;
        int[] dpTable = new int[n];
        Arrays.fill(dpTable, 10001);
        dpTable[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= n) {
                    dpTable[i] = 1;
                }
                if (dpTable[i + j] != 10001) {
                    dpTable[i] = Math.min(dpTable[i + j] + 1, dpTable[i]);
                }
            }
        }
        return dpTable[0];
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));

    }

}
