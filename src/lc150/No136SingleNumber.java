package lc150;

/**
 * @see <a href="https://leetcode.cn/problems/single-number/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No136SingleNumber {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num:nums){
            res ^= num;
        }
        return res;
    }
}
