package LC100Again;


import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;

public class Lc084 {

    public int numSquares(int n) {
        int[] dpTable = new int[n + 1];
        Arrays.fill(dpTable, n);
        dpTable[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                if (i < j * j) {
                    break;
                }
                dpTable[i] = Math.min(dpTable[i], dpTable[i - j * j] + 1);
            }
        }
        return dpTable[n];
    }


    @Test(description = "")
    public void test() throws Exception {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
        System.out.println(numSquares(10));

    }
}
