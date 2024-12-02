package lc100;

import com.sun.org.apache.xpath.internal.res.XPATHErrorResources_pt_BR;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class No279 {

    int[] memo;

    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int result = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                result = Math.min(result, f[i - j * j]);
            }
            f[i] = result + 1;
        }
        return f[n];
    }


    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(numSquares(12), 3);
        Assert.assertEquals(numSquares(13), 2);
    }
}
