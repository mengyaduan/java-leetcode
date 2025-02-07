package LcSpring100;

import java.util.HashMap;

public class No219ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> helper = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];
            if (helper.containsKey(item) && i - helper.get(item) <= k) {
                return true;
            }
            helper.put(item, i);
        }
        return false;
    }
}
