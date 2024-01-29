package Lc.KrahetsInterview.Bit;

/**
 * @see <a href="https://leetcode.cn/problems/number-of-1-bits/description/?envType=study-plan-v2&envId=selected-coding-interview">汉明重量</a>
 **/
public class No191 {

    public int hammingWeight(int n) {
        int count = 0;
        int bit = 1;
        // 涉及有无符号问题，只能用不等于0
        while (n != 0) {
            count += n & bit;
            // 无符号的右移是三个，有符号是两个>>
            n = n >>> 1;
        }
        return count;
    }

}

