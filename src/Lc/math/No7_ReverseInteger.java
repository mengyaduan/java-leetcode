package Lc.math;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/reverse-integer/description/">整数反转</a>
 **/
public class No7_ReverseInteger {

    public int reverse(int x) {
        int flag = x > 0 ? 1 : -1;
        int baseNumber = 214748364 * flag;
        // 正常反转
        int res = 0;
        int count = 0;
        while (x != 0) {
            if (count < 9) {
                // 不需要任何操作，直接处理就行了
                res = res * 10;
                res += (x % 10);
                x /= 10;
                count++;
                continue;
            }
            // 如果已经9位了，不可以粗暴*10了，需要判断大小
            if (res > 0 && (res > baseNumber || x > 7)) {
                // 超过上限
                return 0;
            }
            if (res < 0 && (res < baseNumber || x < -8)) {
                // 超过下限
                return 0;
            }
            // 在baseNumber可控范围内时，可以*10
            return res * 10 + x;
        }
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println("======================");

        System.out.println(reverse(-2147483412));
//        System.out.println(reverse(2147483641));
//        System.out.println(reverse(1534236469));
//        System.out.println(reverse(123));
//        System.out.println(reverse(-1473847412));

    }

}

