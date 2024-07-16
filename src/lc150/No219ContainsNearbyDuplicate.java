package lc150;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.cn/problems/contains-duplicate-ii/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No219ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> helper = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (helper.containsKey(val) && i - helper.get(val) <= k) {
                return true;
            } else {
                helper.put(val, i);
            }
        }
        return false;
    }
}
