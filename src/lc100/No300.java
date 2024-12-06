package lc100;

import org.testng.Assert;
import org.testng.annotations.Test;

public class No300 {
    public int lengthOfLIS(int[] nums) {
        int result = 1;
        int[] table = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            table[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    table[i] = Math.max(table[i], table[j] + 1);
                }
            }
            result = Math.max(result, table[i]);
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}), 4);


    }
}
