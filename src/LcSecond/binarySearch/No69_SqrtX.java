package LcSecond.binarySearch;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/sqrtx/description/">开根号</a>
 **/
public class No69_SqrtX {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 1;
        int right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    /**
     * 用牛顿迭代法不断求解近似值
     *
     * @param x
     * @return
     */
    public int NewtonMySqrt(int x) {
        long f = x;
        while (f * f > x) f = (f + x / f) / 2;
        return (int) f;
    }


    @Test(description = "")
    public void test2() throws Exception {
        Assert.assertEquals(NewtonMySqrt(2147395600), 46340);
        Assert.assertEquals(NewtonMySqrt(0), 0);
        Assert.assertEquals(NewtonMySqrt(1), 1);
        Assert.assertEquals(NewtonMySqrt(8), 2);

    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(mySqrt(2147395600), 46340);
        Assert.assertEquals(mySqrt(0), 0);
        Assert.assertEquals(mySqrt(1), 1);
        Assert.assertEquals(mySqrt(8), 2);

    }
}

