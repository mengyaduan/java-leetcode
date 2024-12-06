package lc100;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class No152 {

    public int maxProduct(int[] nums) {
        int[][] table = new int[nums.length][2];
        for (int[] row : table) {
            Arrays.fill(row, 0);
        }
        table[0][0] = Math.max(nums[0], 0);
        table[0][1] = Math.min(nums[0], 0);
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                table[i][0] = Math.max(table[i - 1][0] * nums[i], nums[i]);
                table[i][1] = table[i - 1][1] * nums[i];
            } else {
                table[i][0] = table[i - 1][1] * nums[i];
                table[i][1] = Math.min(table[i - 1][0] * nums[i], nums[i]);
            }
            result = Math.max(result, table[i][0]);
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(maxProduct(new int[]{2, 3, -3, 4}), 6);
        Assert.assertEquals(maxProduct(new int[]{2, 3, -3, -4}), 72);
        Assert.assertEquals(maxProduct(new int[]{2, 3, 0, -3, -4}), 12);
        Assert.assertEquals(maxProduct(new int[]{2, -3, -3, -4}), 18);
        Assert.assertEquals(maxProduct(new int[]{-2, -3, -3, -4}), 72);

    }
}
