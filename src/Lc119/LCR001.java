package Lc119;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LCR001 {

    public int divide(int a, int b) {
        if (a == b) {
            return 1;
        }
        if (a == 0 || b == Integer.MIN_VALUE) {
            return 0;
        }
        if (b == 1 || b == -1) {
            return b == 1 ? a : (a == Integer.MIN_VALUE ? Integer.MAX_VALUE : -a);
        }
        if (b == Integer.MAX_VALUE && a == Integer.MIN_VALUE) {
            return -1;
        }

        int result = 0;
        if (a > 0 && b > 0) {
            while (a >= b) {
                a -= b;
                result += 1;
            }
        } else if (a < 0 && b < 0) {
            while (a <= b) {
                a += -b;
                result += 1;
            }
        } else if (a > 0 && b < 0) {
            while (a >= -b) {
                a += b;
                result -= 1;
            }
        } else {
            while (a == Integer.MIN_VALUE || -a >= b) {
                // a取最小值的时候，不能取反，直接进来算就行
                a += b;
                result -= 1;
            }
        }
        return result;
    }


    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(divide(15, 2), 7);
        Assert.assertEquals(divide(-15, 2), -7);
        Assert.assertEquals(divide(15, -2), -7);
        Assert.assertEquals(divide(-15, -2), 7);
        Assert.assertEquals(divide(Integer.MIN_VALUE, -1), Integer.MAX_VALUE);
        Assert.assertEquals(divide(Integer.MIN_VALUE, Integer.MAX_VALUE), -1);
        Assert.assertEquals(divide(Integer.MAX_VALUE, Integer.MIN_VALUE), 0);

    }
}
