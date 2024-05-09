package LcSecond.binarySearch;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @see <a href="https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/description/">在一堆长方形中找到随机的坐标</a>
 */
public class No497_RandomPointInRectangles {

    /**
     * 一堆不重叠的长方形，随机返回被这些长方形覆盖的坐标
     * - 长方形的面积就是他的概率，先根据面积随机出一个来，命中指定的长方形
     * - 然后在一个长方形里面随机出一个数字
     */


    HashMap<Integer, Integer> memo = new HashMap<>();
    int n = 10000;

    @Test(description = "")
    public void test() throws Exception {
        int[][] rects = new int[][]{
                {-2, -2, 1, 1}, {2, 2, 4, 6}
        };
        SolutionRecs solutionRecs = new SolutionRecs(rects);
        for (int i = 0; i < n; i++) {
            int[] x = solutionRecs.pick();
            if (x[0] >= -2 && x[0] <= 1 && x[1] >= -2 && x[1] <= 1) {
                memo.put(1, memo.getOrDefault(1, 0) + 1);
            } else if (x[0] >= 2 && x[0] <= 4 && x[1] >= 2 && x[1] <= 6) {
                memo.put(2, memo.getOrDefault(2, 0) + 1);
            } else {
                memo.put(3, memo.getOrDefault(3, 0) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : memo.entrySet()) {
            System.out.println(entry.getKey() + ": " + (double) entry.getValue() / n);
        }
    }
}

class SolutionRecs {

    /**
     * 长方形面积
     */
    int[] area;
    int[][] rects;

    public SolutionRecs(int[][] rects) {
        this.rects = rects;
        area = new int[rects.length];
        area[0] = calculateArea(rects[0]);
        for (int i = 1; i < rects.length; i++) {
            area[i] = calculateArea(rects[i]) + area[i - 1];
        }
    }

    public int[] pick() {
        int n = rects.length;
        Random random = new Random();
        int target = random.nextInt(area[n - 1]);
        // 通过二分法，定位到指定的长方形
        int l = 0, r = n - 1;
        int idx = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (area[mid] > target) {
                idx = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        // 找到长方形后，计算坐标就行了
        int[] rect = rects[idx];
        int item = idx > 0 ? target - area[idx - 1] : target;
        // 计算位置
        int x = rect[2] - rect[0] + 1;
        int xPlus = item % x;
        int yPlus = item / x;
        return new int[]{rect[0] + xPlus, rect[1] + yPlus};
    }

    public int calculateArea(int[] rectangle) {
        int x = rectangle[2] - rectangle[0] + 1;
        int y = rectangle[3] - rectangle[1] + 1;
        return x * y;
    }
}