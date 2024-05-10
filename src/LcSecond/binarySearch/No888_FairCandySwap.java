package LcSecond.binarySearch;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/fair-candy-swap/description/">互换糖果</a>
 **/
public class No888_FairCandySwap {

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0;
        int sumB = 0;
        for (int item : aliceSizes) {
            sumA += item;
        }
        for (int item : bobSizes) {
            sumB += item;
        }
        int fair = (sumA + sumB) / 2;
        int diff = fair - sumA;
        Arrays.sort(bobSizes);
        for (int i = 0; i < aliceSizes.length; i++) {
            int a = aliceSizes[i];
            boolean hasTarget = findBox(bobSizes, a + diff);
            if (hasTarget) {
                return new int[]{a, a + diff};
            }
        }
        return null;
    }

    private boolean findBox(int[] bobSizes, int target) {
        int l = 0, r = bobSizes.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (bobSizes[mid] == target) {
                return true;
            } else if (bobSizes[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] alice = new int[]{1, 1};
        int[] bob = new int[]{2, 2};
        int[] x = fairCandySwap(alice, bob);
        System.out.println(x[0]);
        System.out.println(x[1]);

    }

}
