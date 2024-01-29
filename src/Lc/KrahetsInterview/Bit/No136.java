package Lc.KrahetsInterview.Bit;

/**
 * @see <a href="https://leetcode.cn/problems/single-number/description/?envType=study-plan-v2&envId=selected-coding-interview"></a>
 **/
public class No136 {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}

