package lc150;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/climbing-stairs/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No70ClimbStairs {

    int[] memo;

    public int climbStairs(int n) {
        memo = new int[n + 2];
        Arrays.fill(memo, -1);
        memo[1] = 1;
        memo[2] = 2;
        return count(n);
    }

    private int count(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }
        int res = count(n - 1) + count(n - 2);
        memo[n] = res;
        return res;
    }


}
