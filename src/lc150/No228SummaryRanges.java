package lc150;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/summary-ranges/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No228SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int j = i;
            int target = nums[i];
            while (j < nums.length && nums[j] == target) {
                target++;
                j++;
            }
            res.add(createString(nums[i], target - 1));
            i = j;
        }
        return res;
    }

    private String createString(int start, int target) {
        if (start == target) {
            return start + "";
        } else {
            return start + "->" + target;
        }
    }

}
