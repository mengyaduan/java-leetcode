package lc150;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/sqrtx/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No69MySqrt {

    public int mySqrt(int x) {
        int l = 0, r = x;
        int res = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (x / mid >= mid) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(mySqrt(1), 1);
        Assert.assertEquals(mySqrt(4), 2);
        Assert.assertEquals(mySqrt(8), 2);
        Assert.assertEquals(mySqrt(9), 3);

    }
}
