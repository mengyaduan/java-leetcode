package Lc.KrahetsInterview.Math;


/**
 * @see <a href="https://leetcode.cn/problems/integer-break/description/?envType=study-plan-v2&envId=selected-coding-interview">整数拆分</a>
 **/
public class No343_IntegerBreak {
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }
        int[] res = new int[n];
        res[0] = 0;
        res[1] = 0;
        res[2] = 1;
        res[3] = 2;
        res[4] = 4;
        for (int i = 5; i < n; i++) {
            res[i] = Math.max(res[i - 3], i - 3) * 3;
        }
        return res[n - 1];
    }
}
