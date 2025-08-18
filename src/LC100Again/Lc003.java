package LC100Again;


import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Lc003 {

    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> helper = new HashMap<>();
        for (int num : nums) {
            helper.put(num, 1);
        }
        int result = 0;
        for (int num : nums) {
            if (helper.containsKey(num)) {
                // 如果还没算过，可以继续
                result = Math.max(result, explore(num, helper));
            }
        }
        return result;
    }

    private int explore(int num, HashMap<Integer, Integer> helper) {
        int res = 1;
        int up = num + 1, down = num - 1;
        while (helper.containsKey(up)) {
            res++;
            helper.remove(up);
            up++;
        }
        while (helper.containsKey(down)) {
            res++;
            helper.remove(down);
            down--;
        }
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));

    }
}
