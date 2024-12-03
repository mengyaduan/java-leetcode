package lc100;

import com.sun.org.apache.xpath.internal.res.XPATHErrorResources_pt_BR;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class No279 {

    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            memo[i] = i;
            for (int j = 1; j * j <= i; j++) {
                memo[i] = Math.min(memo[i], 1 + memo[i - j * j]);
            }
        }
        return memo[n];
    }


    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(numSquares(12), 3);
        Assert.assertEquals(numSquares(13), 2);
    }
}
