package lc75;

import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * @see <a href="https://leetcode.cn/problems/can-place-flowers/description/?envType=study-plan-v2&envId=leetcode-75">种花问题</a>
 */
public class No605_CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        ArrayList<Integer> ones = new ArrayList<>();
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                ones.add(i);
            }
        }
        if (ones.isEmpty()) {
            // 没有1，则直接计算即可
            return countZero(flowerbed.length, 0, 0) >= n;
        }
        int res = 0;
        // 先把所有1之间的算好
        for (int i = 1; i < ones.size(); i++) {
            int zeroNum = ones.get(i) - ones.get(i - 1) - 1;
            res += countZero(zeroNum, 1, 1);
        }
        // 计算两头
        if (ones.get(0) != 0) {
            res += countZero(ones.get(0), 0, 1);
        }
        if (ones.get(ones.size() - 1) != flowerbed.length - 1) {
            int zeroNum = flowerbed.length - ones.get(ones.size() - 1) - 1;
            res += countZero(zeroNum, 1, 0);
        }
        return res >= n;
    }

    public int countZero(int n, int left, int right) {
        if (left != 1 && right != 1) {
            // 如果两边没有1，那么最多(x+1)/2
            return (n + 1) / 2;
        } else if (left == 1 && right == 1) {
            // 如果两边都是1，那么最多(x-1)/2
            return (n - 1) / 2;
        } else {
            // 如果一边1一边0，那么最多x/2
            return n / 2;
        }
    }


    public boolean canPlaceFlowersAnswer(int[] flowerbed, int n) {
        for (int i = 0, len = flowerbed.length; i < len && n > 0; ) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                n--;
                i += 2;
            } else {
                i += 3;
            }
        }
        return n <= 0;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] flowers = new int[]{1, 0, 1, 0, 0, 0};
        int n = 2;
        System.out.println(canPlaceFlowersAnswer(flowers, n));
        System.out.println(canPlaceFlowers(flowers, n));

    }
}
