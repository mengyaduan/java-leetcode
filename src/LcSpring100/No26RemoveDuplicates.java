package LcSpring100;

import org.testng.annotations.Test;

public class No26RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int i = 1, j = 1;
        int cur = nums[0];
        while (j < nums.length) {
            if (nums[j] != cur) {
                cur = nums[j];
                nums[i] = cur;
                i++;
            }
            j++;
        }
        return i;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));

    }
}
