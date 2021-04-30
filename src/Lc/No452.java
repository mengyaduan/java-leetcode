package Lc;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @see <a href="https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/</a>
 **/
public class No452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1) {
            return points.length;
        }
        int len = points.length;

        // 方法1
        Arrays.sort(points, (a, b) -> {
            if ((a[1] >= 0 && b[1] >= 0) || (a[1] <= 0 && b[1] <= 0)) {
                return a[1] - b[1];
            } else {
                if (a[1] > 0 && b[1] < 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        // 方法2：溢出情况的正解
        Arrays.sort(points, (a, b) -> Math.abs(a[1]) - Math.abs(b[1]));
        int cursor = 1;
        int counter = 1;
        int start = points[0][1];
        while (cursor < len) {
            if (points[cursor][0] > start) {
                start = points[cursor][1];
                counter++;
            }
            cursor++;
        }
        return counter;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                // 
                {new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}, 2},
                {new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 12}}, 4},
                {new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}, 2},
                {new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}}, 2},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[][] points, int res) throws Exception {
        int n = findMinArrowShots(points);
        Assert.assertTrue(n == res);
    }
}
