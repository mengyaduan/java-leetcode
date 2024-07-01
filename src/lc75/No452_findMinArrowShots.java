package lc75;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/?envType=study-plan-v2&envId=leetcode-75">射爆气球的最小箭数</a>
 */
public class No452_findMinArrowShots {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] <= b[0] ? -1 : 1;
            } else {
                return a[1] <= b[1] ? -1 : 1;
            }
        });
        int res = 1;
        int right = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= right) {
                right = Math.min(right, points[i][1]);
                continue;
            }
            res++;
            right = points[i][1];
        }
        return res;
    }

    @DataProvider(name = "unit")
    public Object[][] unit() {
        return new Object[][]{
                {new int[][]{{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}}, 2},
                {new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}}, 2},
                {new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}, 2},
                {new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}, 4},
                {new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}, 2},
        };
    }

    @Test(description = "", dataProvider = "unit")
    public void test(int[][] points, int res) throws Exception {
        Assert.assertEquals(findMinArrowShots(points), res);
    }
}
