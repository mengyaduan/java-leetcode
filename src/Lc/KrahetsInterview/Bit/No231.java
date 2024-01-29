package Lc.KrahetsInterview.Bit;

/**
 * @see <a href="https://leetcode.cn/problems/power-of-two/description/?envType=study-plan-v2&envId=selected-coding-interview">2的幂</a>
 **/
public class No231 {
    public boolean isPowerOfTwo(int n) {
        int res = 0;
        if (n <= 0) {
            return false;
        }
        while (n != 0) {
            res += n & 1;
            if (res > 1) {
                return false;
            }
            n >>= 1;
        }
        return true;
    }
}
