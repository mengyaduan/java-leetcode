package lc150;

/**
 * @see <a href="https://leetcode.cn/problems/factorial-trailing-zeroes/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No172TrailingZeroes {

    public int trailingZeroes(int n) {
        int count = 0;
        while (n != 0) {
            n = n / 5;
            count += n;
        }
        return count;
    }
}
