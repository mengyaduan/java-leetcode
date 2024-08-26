package lc150;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/reverse-bits/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No190ReverseBits {

    public int reverseBits(int n) {
        int res = 0;
        int count = 0;
        while (n != 0 && count < 32) {
            res |= (n & 1) << (31 - count);
            n >>>= 1;
            count++;
        }
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(reverseBits(-3));
//        System.out.println(0 << 1);
//        System.out.println(1 >> 1);
//        System.out.println(-1 << 1);

    }

}
