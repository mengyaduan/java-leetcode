package LC100Again;


import org.testng.annotations.Test;

import java.util.HashMap;

public class Lc010 {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        int result = 0;
        int total = 0;
        for (int item : nums) {
            total += item;
            int need = total - k;
            if (preSum.containsKey(need)) {
                result += preSum.get(need);
            }
            preSum.put(total, preSum.getOrDefault(total, 0) + 1);
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(subarraySum(new int[]{1, 2, 1, 2, 1}, 3));
        System.out.println(subarraySum(new int[]{1}, 0));
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0));

    }
}
