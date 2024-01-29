package Lc.KrahetsInterview.Bit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * @see <a href="https://leetcode.cn/problems/sum-of-two-integers/description/?envType=study-plan-v2&envId=selected-coding-interview">两个整数之和</a>
 **/
public class No371 {
    public int getSum(int a, int b) {
        int xor = 0;
        while (true) {
            xor = a ^ b;
            int and = a & b;
            int flag = and << 1;
            if (flag == 0) {
                break;
            }
            a = xor;
            b = flag;
        }
        return xor;
    }


    @DataProvider(name = "unit")
    public Object[][] unit() {
        Random random = new Random();
        return new Object[][]{
                {random.nextInt(1000), random.nextInt(1000)},
        };
    }

    @Test(description = "", dataProvider = "unit")
    public void testget(int a, int b) throws Exception {
        int x = getSum(a, b);
        Assert.assertEquals(x, a + b);

    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(getSum(1, -1));
        System.out.println(getSum(9, -3));
    }
}
