package lc75;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/minimum-flips-to-make-a-or-b-equal-to-c/description/?envType=study-plan-v2&envId=leetcode-75">最小翻转次数</a>
 */
public class No1318_minFlips {

    public int minFlips(int a, int b, int c) {
        int count = 0;
        while (a != 0 || b != 0 || c != 0) {
            int A = a & 1;
            a >>= 1;
            int B = b & 1;
            b >>= 1;
            int C = c & 1;
            c >>= 1;
            if (C == 0) {
                count += A + B;
            } else {
                count += (A + B == 0 ? 1 : 0);
            }
        }
        return count;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(minFlips(8, 3, 5), 3);
//        Assert.assertEquals(minFlips(2, 6, 5), 3);
//        Assert.assertEquals(minFlips(4, 2, 7), 1);
//        Assert.assertEquals(minFlips(1, 2, 3), 0);

    }

}
