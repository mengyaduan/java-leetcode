package Lc.KrahetsInterview.Search;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/first-bad-version/description/"></a>
 **/
public class No278 {

    int wrongVersion = 1;

    public int firstBadVersion(int n) {
        int res = 0;
        int i = 0;
        int j = n - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (isBadVersion(mid + 1)) {
                res = mid + 1;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return res;
    }

    boolean isBadVersion(int version) {
        if (version >= wrongVersion) {
            return true;
        }
        return false;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                //
//                {5, 4},
                {10, 6},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int n, int expected) {
        wrongVersion = expected;
        int res = firstBadVersion(n);
        Assert.assertEquals(res, expected);

    }

}

