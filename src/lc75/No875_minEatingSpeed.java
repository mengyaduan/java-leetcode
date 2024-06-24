package lc75;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/koko-eating-bananas/description/?envType=study-plan-v2&envId=leetcode-75">爱吃蕉的coco</a>
 */
public class No875_minEatingSpeed {

    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int sum = 0;
        for (int i : piles) {
            sum += i;
        }
        int avg = sum / h + (sum % h == 0 ? 0 : 1);
        int max = piles[piles.length - 1];
        int l = avg, r = max;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canEatAll(piles, mid, h)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean canEatAll(int[] piles, int k, int h) {
        int n = piles.length;
        int total = 0;
        for (int item : piles) {
            if (item <= k) {
                total += 1;
            } else {
                total += item / k + (item % k == 0 ? 0 : 1);
            }
            if (total > h) {
                return false;
            }
        }
        return true;
    }

}
