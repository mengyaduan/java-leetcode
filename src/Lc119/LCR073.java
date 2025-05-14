package Lc119;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.apple.laf.resources.aqua_es;

public class LCR073 {

    public int minEatingSpeed(int[] piles, int h) {
        // 上限就是piles里面的最大值，h一定大于piles.length
        // 下限假设就是1，然后二分取最小的满足条件的值
        int r = -1;
        for (int i = 0; i < piles.length; i++) {
            r = Math.max(r, piles[i]);
        }
        int l = 1;
        int result = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (eatAll(mid, piles, h)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }

    public boolean eatAll(int mid, int[] piles, int h) {
        int need = 0;
        for (int item : piles) {
            need += item / mid + (item % mid > 0 ? 1 : 0);
        }
        return need <= h;
    }

    @Test
    public void unit() {
        int[] piles = new int[]{30, 11, 23, 4, 20};
        int h = 5;
        Assert.assertEquals(minEatingSpeed(piles, h), 30);
    }
}
