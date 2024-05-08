package LcSecond.binarySearch;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/koko-eating-bananas/description/">最慢的吃蕉速度</a>
 */
public class No875_MinEatSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int totalBananas = Arrays.stream(piles).sum();
        int l = totalBananas / h + totalBananas % h == 0 ? 0 : 1;
        int r = getMaxPile(piles);
        int speed = r;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canEatAll(mid, piles, h)) {
                speed = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return speed;
    }

    private int getMaxPile(int[] piles) {
        int res = 0;
        for (int pile : piles) {
            if (pile > res) {
                res = pile;
            }
        }
        return res;
    }

    private boolean canEatAll(int mid, int[] piles, int h) {
        int needHours = 0;
        for (int pile : piles) {
            needHours += pile / mid;
            if (pile % mid != 0) {
                needHours++;
            }
            if (needHours > h) {
                return false;
            }
        }
        return true;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] piles = new int[]{
                30, 11, 23, 4, 20
        };
        Assert.assertEquals(minEatingSpeed(piles, 6), 23);

        piles = new int[]{
                30, 11, 23, 4, 20
        };
        Assert.assertEquals(minEatingSpeed(piles, 5), 30);

        piles = new int[]{
                3, 6, 7, 11
        };
        Assert.assertEquals(minEatingSpeed(piles, 8), 4);


    }

    @Test(description = "")
    public void test123() throws Exception {
        int[] arr = new int[]{
                312884470
        };

        System.out.println(minEatingSpeed(arr, 968709470));

    }
}
