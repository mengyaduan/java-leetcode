package lc150;

import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/powx-n/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class No50Pow {

    HashMap<Integer, Double> helper;

    public double myPow(double x, int n) {
        if (x == 0.0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        if (x == -1) {
            return n % 2 == 0 ? 1 : -1;
        }
        if (n == 0) {
            return 1;
        }
        if (n == Integer.MIN_VALUE) {
            // 单独处理
            return (myPow(1 / x, Integer.MAX_VALUE) * 1 / x);
        }
        if (n < 0) {
            return 1 / myPow(x, -n);
        }
        helper = new HashMap<>();
        return myPow1(x, n);
    }

    public double myPow1(double x, int n) {
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        if (helper.containsKey(n)) {
            return helper.get(n);
        }
        // n>0 且 n<=Integer.Max
        double res = 1;
        res = myPow1(x, n / 2) * myPow1(x, n - n / 2);
        helper.put(n, res);
        return res;
    }


    @Test(description = "")
    public void test() throws Exception {
        System.out.println(myPow(2.0, -2147483648));
//        System.out.println(myPow(2.0, 10));
//        System.out.println(myPow(2.0, -2));
//        System.out.println(myPow(2.1, 3));


    }
}
