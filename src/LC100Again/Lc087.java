package LC100Again;


import org.testng.annotations.Test;

import java.util.Arrays;

public class Lc087 {

    public int lengthOfLIS(int[] nums) {
        int[] dpTable = new int[nums.length];
        Arrays.fill(dpTable, 1);
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dpTable[j] + 1 > dpTable[i]) {
                    dpTable[i] = dpTable[j] + 1;
                    result = Math.max(result, dpTable[i]);
                }
            }
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(lengthOfLIS(new int[]{7, 7, 7, 7, 7}));
        System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));

    }

}
