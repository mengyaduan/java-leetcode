package LcSecond.binarySearch;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/description/">在一堆长方形中找到随机的坐标</a>
 */
public class No497_RandomPointInRectangles {

    /**
     * 一堆不重叠的长方形，随机返回被这些长方形覆盖的坐标
     * - 长方形的面积就是他的概率，先根据面积随机出一个来，命中指定的长方形
     * - 然后在一个长方形里面随机出一个数字
     */

    @Test(description = "")
    public void test() throws Exception {


    }

}

class SolutionRecs {
    // TO_YAMENG 2024/5/9

    /**
     * 长方形面积
     */
    int[] area;
    int[][] rects;
    int sum = 0;

    public SolutionRecs(int[][] rects) {
        this.rects = rects;
        area = new int[rects.length];
        for (int i = 0; i < rects.length; i++) {
            area[i] = calculateArea(rects[i]);
            sum += area[i];
        }
    }

    public int[] pick() {
        int n = rects.length;

        return null;
    }

    public int calculateArea(int[] rectangle) {
        return 0;
    }
}