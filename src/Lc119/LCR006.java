package Lc119;

import org.testng.annotations.Test;

public class LCR006 {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                return new int[]{i, j};
            }
        }
        return null;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(twoSum(new int[]{1, 2, 4, 6, 10}, 8));

    }
}
