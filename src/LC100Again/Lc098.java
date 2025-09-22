package LC100Again;


import org.testng.annotations.Test;

import static DataStruct.tools.printIntArray;

public class Lc098 {

    public void sortColors(int[] nums) {
        int r = 0, w = 0;
        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];
            nums[i] = 2;
            if (item <= 1) {
                nums[w++] = 1;
            }
            if (item == 0) {
                nums[r++] = 0;
            }
        }
    }


    @Test(description = "")
    public void test() throws Exception {
        int[] x = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(x);
        printIntArray(x);
        System.out.println();

    }

}
