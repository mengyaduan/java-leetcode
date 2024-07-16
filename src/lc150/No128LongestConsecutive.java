package lc150;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No128LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> helper = new HashMap<>();
        for (int item : nums) {
            helper.put(item, 1);
        }
        for (int item : nums) {
            if (helper.get(item) == 0) {
                // 已经计算过了，直接跳过
                continue;
            }
            int chain = 1;
            helper.put(item, 0);
            int up = item + 1;
            int down = item - 1;
            while (true) {
                if (!helper.containsKey(up) && !helper.containsKey(down)) {
                    res = Math.max(res, chain);
                    break;
                }
                if (helper.containsKey(up)) {
                    helper.put(up, 0);
                    up++;
                    chain++;
                }
                if (helper.containsKey(down)) {
                    helper.put(down, 0);
                    down--;
                    chain++;
                }
            }
        }
        return res;
    }

}
