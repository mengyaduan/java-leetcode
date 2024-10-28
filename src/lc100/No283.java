package lc100;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.Arrays;

public class No283 {

    int count = 0;

    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                continue;
            }
            // 找到下一个不是0的
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] != 0) {
                    count++;
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                    break;
                }
            }
        }
    }




    @Test(description = "")
    public void test() throws Exception {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
        System.out.println(count);
//        moveZeroes(new int[]{0});
    }
}
