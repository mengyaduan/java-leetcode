package lc100;

import java.util.Arrays;
import java.util.HashMap;

public class No1 {

    public int[] twoSum(int[] nums, int target) {

        int[][] data = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            data[i][0] = nums[i];
            data[i][1] = i;
        }
        Arrays.sort(data, (a, b) -> {
            return a[0] - b[0];
        });
        int i = 0, j = nums.length - 1;
        while (i < nums.length && j > i) {
            int left = data[i][0];
            int right = data[j][0];
            if (left + right == target) {
                return new int[]{data[i][1], data[j][1]};
            }
            if (left + right > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }

}
