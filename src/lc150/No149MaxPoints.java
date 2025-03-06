package lc150;

import org.testng.annotations.Test;

public class No149MaxPoints {

    public int maxPoints(int[][] points) {
        // 如果只有一个点
        int result = 1;
        // 遍历，求解斜率，然后匹配其他的节点
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                // 计算当前两个节点的斜率和偏移量
                boolean vertical = false;
                if (points[j][0] - points[i][0] == 0) {
                    vertical = true;
                }
                int line = 2;
                for (int l = j + 1; l < points.length; l++) {
                    if (vertical) {
                        if (points[l][0] == points[i][0]) {
                            line++;
                        }
                    } else {
                        // (y2-y1)/(x2-x1) == (y-y1)/(x-x1)
                        if ((points[j][1] - points[i][1]) * (points[l][0] - points[i][0]) == (points[j][0] - points[i][0]) * (points[l][1] - points[i][1])) {
                            // 如果符合斜率，则++
                            line++;
                        }
                    }
                }
                result = Math.max(result, line);
            }
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[][] array = {
                {1, 1},
                {3, 2},
                {5, 3},
                {4, 1},
                {2, 3},
                {1, 4}
        };
        System.out.println(maxPoints(array));

    }

    @Test(description = "")
    public void test2() throws Exception {
        int[][] array = {
                {-184, -551},
                {-105, -467},
                {-90, -394},
                {-60, -248},
                {115, 359},
                {138, 429},
                {60, 336},
                {150, 774},
                {207, 639},
                {-150, -686},
                {-135, -613},
                {92, 289},
                {23, 79},
                {135, 701},
                {0, 9},
                {-230, -691},
                {-115, -341},
                {-161, -481},
                {230, 709},
                {-30, -102}
        };
        System.out.println(maxPoints(array));

    }
}
