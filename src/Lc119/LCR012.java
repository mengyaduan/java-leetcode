package Lc119;

import org.testng.annotations.Test;

public class LCR012 {

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int curS = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curS == sum - curS - nums[i]) {
                return i;
            }
            curS += nums[i];
        }
        return -1;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(pivotIndex(new int[]{2, -1, 1}));
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));

    }
}
