package lc75;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/n-th-tribonacci-number/description/?envType=study-plan-v2&envId=leetcode-75">第N个泰波那契数</a>
 */
public class No1137_tribonacci {

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 3) {
            return 1;
        }
        int a = 0, b = 1, c = 1;
        n -= 2;
        while (n-- > 0) {
            int x = a + b + c;
            a = b;
            b = c;
            c = x;
        }
        return c;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(tribonacci(4));
        System.out.println(tribonacci(25));

    }
}
