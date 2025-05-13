package Lc119;

import org.testng.annotations.Test;

public class LCR070 {
    public int singleNonDuplicate(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
        System.out.println(singleNonDuplicate(new int[]{1,1,5,5,2,2,4,4,8}));

    }
}
