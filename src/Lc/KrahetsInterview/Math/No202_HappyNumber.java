package Lc.KrahetsInterview.Math;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;

/**
 * @see <a href="https://leetcode.com/problems/happy-number/description/">快乐数</a>
 **/
public class No202_HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> used = new HashSet<>();
        while (true) {
            int oneTurn = calculateRes(n);
            if (oneTurn == 1) {
                return true;
            }
            if (used.contains(oneTurn)) {
                return false;
            } else {
                used.add(oneTurn);
            }
            n = oneTurn;
        }
    }

    public int calculateRes(int n) {
        int res = 0;
        while (n > 0) {
            int x = n % 10;
            res += x * x;
            n /= 10;
        }
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertTrue(isHappy(19));
        Assert.assertTrue(isHappy(1));
        Assert.assertFalse(isHappy(2));
        Assert.assertFalse(isHappy(18));

    }

}

