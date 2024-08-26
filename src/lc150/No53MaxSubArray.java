package lc150;

/**
 * @see <a href="https://leetcode.cn/problems/maximum-subarray/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No53MaxSubArray {


    public int maxSubArray(int[] nums) {
        int last = nums[0];
        int res = last;
        for (int i = 1; i < nums.length; i++) {
            int item = nums[i];
            last = Math.max(item, last + item);
            res = Math.max(res, last);
        }
        return res;
    }
}
