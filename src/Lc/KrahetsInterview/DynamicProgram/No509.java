package Lc.KrahetsInterview.DynamicProgram;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/fibonacci-number/description/">斐波那契数列</a>
 **/
public class No509 {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int fn2 = 0;
        int fn1 = 1;
        int count = 1;
        while (count < n) {
            int x = fn1 + fn2;
            fn2 = fn1;
            fn1 = x;
            count++;
        }

        return fn1;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));

    }

}

