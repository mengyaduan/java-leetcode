package Lc.KrahetsInterview.Math;

import org.testng.Assert;
import org.testng.annotations.Test;

public class No400_FindNthDigit {
    // 按照9，90，900...划分区间，每个区间都是9*pow(10,base)个数，numbersBefore代表n在哪个区间之后
    // 每个区间的数字个数都是 9 * base* pow(10,base) 个，bitsBefore代表n在区间的起点
    // 例如 n =200，那么算出来的numbersBefore=9+90=99，bitsBefore=9+90*2=189
    // 然后从189往后数x个数，x=(n-bitsBefore)/base个.....
    long bitsBefore = 0;
    long numbersBefore;

    public int findNthDigit(int n) {
        numbersBefore = 0;
        bitsBefore = 0;
        if (n <= 9) {
            return n;
        }
        int rangeBase = countRange(n);
        long leftBits = n - bitsBefore;
        long point = numbersBefore + leftBits / rangeBase + (leftBits % rangeBase == 0 ? 0 : 1);
        long index = leftBits % rangeBase == 0 ? rangeBase - 1 : leftBits % rangeBase - 1;
        long divTen = rangeBase - 1 - index;
        print(rangeBase, point, index);
        while (divTen-- > 0) {
            point /= 10;
        }
        return (int) (point % 10);
    }

    public int countRange(int n) {
        int base = 1;
        while (true) {
            int count = 1;
            long bound = base * 9L;
            while (count < base) {
                bound *= 10;
                count++;
            }
            bitsBefore += bound;
            if (n <= bitsBefore) {
                bitsBefore -= (bound);
                break;
            }
            numbersBefore += bound / base;
            base++;
        }
        return base;
    }

    public void print(int rangeBase, long point, long index) {
        System.out.println("当前所处区间：" + rangeBase);
        System.out.println("区间起点的数字是：" + numbersBefore);
        System.out.println("区间起点的位数：" + bitsBefore);
        System.out.println("当前定位到的数字：" + point);
        System.out.println("当前定位到的数字的位数：" + index);

    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(findNthDigit(1000000000), 1);
        Assert.assertEquals(findNthDigit(100), 5);
        Assert.assertEquals(findNthDigit(200), 0);
        Assert.assertEquals(findNthDigit(300), 6);

    }


}
