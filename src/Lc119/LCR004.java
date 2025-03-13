package Lc119;

import java.util.HashMap;

public class LCR004 {

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> helper = new HashMap<>();
        for (int item : nums) {
            int count = helper.getOrDefault(item, 0);
            if (count == 2) {
                helper.remove(item);
            } else {
                helper.put(item, count + 1);
            }
        }
        return helper.keySet().iterator().next();
    }
}
