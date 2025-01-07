package Lc;

import com.sun.org.apache.xerces.internal.dom.DeepNodeListImpl;
import org.testng.annotations.Test;

public class No29Divide {

    public int divide(int dividend, int divisor) {
        int result = 0;
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        }
        // ++
        if (dividend >= 0 && divisor > 0) {
            while (dividend > 0 && dividend >= divisor) {
                dividend -= divisor;
                if (result < Integer.MAX_VALUE) {
                    result += 1;
                } else {
                    break;
                }
            }
        }
        // +-
        else if (dividend >= 0 && divisor < 0) {
            while (dividend > 0 && -dividend <= divisor) {
                dividend += divisor;
                if (result > Integer.MIN_VALUE) {
                    result -= 1;
                } else {
                    break;
                }
            }
        }
        // -+
        else if (dividend <= 0 && divisor > 0) {
            while (dividend < 0 && dividend <= -divisor) {
                dividend += divisor;
                if (result > Integer.MIN_VALUE) {
                    result -= 1;
                } else {
                    break;
                }
            }
        }
        // --
        else if (dividend <= 0 && divisor < 0) {
            while (dividend < 0 && dividend <= divisor) {
                dividend -= divisor;
                if (result < Integer.MAX_VALUE) {
                    result += 1;
                } else {
                    break;
                }
            }
        }

        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(divide(10, 3));
        System.out.println(divide(10, 5));
        System.out.println(divide(10, -5));
        System.out.println(divide(-7, 2));

    }
}
