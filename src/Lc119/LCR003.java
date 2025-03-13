package Lc119;

import org.testng.annotations.Test;

import static DataStruct.tools.printIntArray;

public class LCR003 {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        if (n == 0) {
            return result;
        }
        result[1] = 1;
        int lastLevelCount = 2;

        for (int i = 2; i <= n; i++) {
            result[i] = result[i - lastLevelCount] + 1;
            if (i + 1 == lastLevelCount * 2) {
                lastLevelCount = lastLevelCount * 2;
            }
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] x = countBits(6);
        printIntArray(x);

    }

}