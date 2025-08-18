package LC100Again;

import java.util.HashMap;

public class Lc001 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> helper = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (helper.containsKey(target - nums[i])) {
                return new int[]{helper.get(target - nums[i]), i};
            }
            helper.put(nums[i], i);
        }
        return new int[]{};
    }
}
