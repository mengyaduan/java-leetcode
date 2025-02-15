package LcSpring100;

import org.testng.annotations.Test;

import java.util.HashMap;

public class No50MyPow {

    HashMap<Integer, Double> helper;

    public double myPow(double x, int n) {
        helper = new HashMap<>();
        return powWithHelper(x, n);
    }

    public double powWithHelper(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        if (helper.containsKey(n)) {
            return helper.get(n);
        }
        int a = n / 2;
        int b = n - n / 2;
        double res = powWithHelper(x, a) * powWithHelper(x, b);
        helper.put(n, res);
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(myPow(2.000, 10));
        System.out.println(myPow(2.100, 3));
        System.out.println(myPow(2.000, -2));

    }

}
