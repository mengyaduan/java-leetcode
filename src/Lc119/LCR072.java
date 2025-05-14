package Lc119;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LCR072 {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int l = 1, r = x / 2;
        int result = 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid == 0) {
                result = 0;
                break;
            }
            if (x / mid >= mid) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }

    @DataProvider
    public Object[][] units() {
        return new Object[][] {
                { 4, 2 },
                { 8, 2 },
                { 0, 0 },
                { 1, 1 },
        };
    }

    @Test(dataProvider = "units")
    public void unit(int x, int result) {
        Assert.assertEquals(mySqrt(x), result);
    }

}
