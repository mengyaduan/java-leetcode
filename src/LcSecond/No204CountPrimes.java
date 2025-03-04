package LcSecond;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class No204CountPrimes {
    // 2,3,5,7,11,13,17,19,23,29,31

    public int countPrimes(int n) {
        if (n <= 2) {
            return n == 2 ? 1 : 0;
        }
        int result = 1;
        for (int i = 3; i < n; i += 2) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            result += isPrime ? 1 : 0;

        }
        return result;
    }

}
