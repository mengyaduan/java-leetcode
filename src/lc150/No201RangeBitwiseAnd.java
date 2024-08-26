package lc150;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/bitwise-and-of-numbers-range/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No201RangeBitwiseAnd {

    public int rangeBitwiseAnd(int left, int right) {
        int res = 0;
        while (left < right) {
            left >>>= 1;
            right >>>= 1;
            res++;
        }
        return left << res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(rangeBitwiseAnd(2147483646, 2147483647));
    }

    @Test(description = "")
    public void test21() throws Exception {
        System.out.println(1 << 1);
        System.out.println(1 << 2);
        System.out.println(1 << 3);

    }

}
