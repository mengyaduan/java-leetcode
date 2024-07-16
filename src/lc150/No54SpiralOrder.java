package lc150;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/spiral-matrix/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No54SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<>();

        int i = 0, j = 0;
        // 定义上下左右边界
        int up = 0, down = m - 1, left = 0, right = n - 1;
        // 前进方向 0左向右，1 上向下，2右向左，3下向上
        int direction = 0;
        while (i >= up && i <= down && j >= left && j <= right) {
            res.add(matrix[i][j]);
            if (direction == 0) {
                if (j == right) {
                    //已经撞墙了，需要转向
                    direction = 1;
                    up += 1;
                    i++;
                } else {
                    j++;
                }
            } else if (direction == 1) {
                if (i == down) {
                    direction = 2;
                    right -= 1;
                    j--;
                } else {
                    i++;
                }
            } else if (direction == 2) {
                if (j == left) {
                    direction = 3;
                    down -= 1;
                    i--;
                } else {
                    j--;
                }
            } else {
                if (i == up) {
                    direction = 0;
                    left += 1;
                    j++;
                } else {
                    i--;
                }
            }
        }
        return res;
    }

}
