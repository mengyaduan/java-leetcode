package lc100;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 以第i个为起点
            calculate(result, nums, i);
        }
        return result;
    }

    private void calculate(List<List<Integer>> result, int[] nums, int i) {
        int x = i + 1, y = nums.length - 1;
        while (x < y) {
            int item = nums[i] + nums[x] + nums[y];
            if (item > 0) {
                y--;
            } else if (item < 0) {
                x++;
            } else {
                ArrayList<Integer> li = new ArrayList<>(Arrays.asList(nums[i], nums[x], nums[y]));
                result.add(li);
                int cur = nums[x];
                while (x < nums.length && nums[x] == cur) {
                    x++;
                }
                cur = nums[y];
                while (y >= 0 && nums[y] == cur) {
                    y--;
                }
            }
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{0, 0, 0}));
        System.out.println(threeSum(new int[]{0, 1, 1}));
    }
}
