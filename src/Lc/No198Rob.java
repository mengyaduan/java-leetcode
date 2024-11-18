package Lc;

import org.testng.Assert;
import org.testng.annotations.Test;

public class No198Rob {

    public int rob(int[] nums) {
        int[][] dpTable = new int[nums.length][2];
        dpTable[0][0] = 0;
        dpTable[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpTable[i][0] = Math.max(dpTable[i - 1][1], dpTable[i - 1][0]);
            dpTable[i][1] = Math.max(dpTable[i - 1][0] + nums[i], dpTable[i - 1][1]);
        }
        return Math.max(dpTable[nums.length - 1][0], dpTable[nums.length - 1][1]);
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(rob(new int[]{1,2,3,1}), 4);
    }
}
