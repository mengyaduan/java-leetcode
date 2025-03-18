package Lc119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCR007 {

    List<List<Integer>> result;

    public List<List<Integer>> threeSum(int[] nums) {
        result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 跳过外层重复值
                continue;
            }
            twoSum(nums, i + 1, nums.length - 1, -nums[i]);
        }
        return result;
    }

    private void twoSum(int[] nums, int i, int j, int target) {
        while (i < j) {
            int item = nums[i] + nums[j];
            if (item == target) {
                result.add(new ArrayList<>(Arrays.asList(-target, nums[i], nums[j])));
                // 将i前进到第一个和nums[i]不一致的值上，才能避免重复
                int cur = nums[i];
                while (i < j && nums[i] == cur) {
                    i++;
                }
                j--;
            } else if (item > target) {
                j--;
            } else {
                i++;
            }
        }


    }

}
