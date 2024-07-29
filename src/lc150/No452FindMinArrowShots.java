package lc150;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No452FindMinArrowShots {

    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1) {
            return points.length;
        }
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        int right = points[0][1];
        int i = 0;
        int res = 1;
        while (i < points.length) {
            // 判断是否可以merge
            int l = points[i][0], r = points[i][1];
            if (right >= r) {
                // 老数据包着新数据，可以公用一支箭，更新左右边界
                right = r;
            } else if (l > right) {
                // 有隔断，需要加一支箭
                res++;
                right = r;
            }
            i++;
        }
        return res;
    }

}
