package lc150;

import org.testng.annotations.Test;

import static DataStruct.tools.createMatrix;
import static DataStruct.tools.showMatrix;

/**
 * @see <a href="https://leetcode.cn/problems/rotate-image/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No48RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int row = 0, col = 0;
        while (n > 1) {
            for (int i = col; i < col + n - 1; i++) {
                // 找到四个待旋转的点
                int x1 = row, y1 = i;
                int step = n - 1;
                int x2 = x1, y2 = y1;
                while (step > 0) {
                    if (y2 == col + n - 1) {
                        x2++;
                    } else {
                        y2++;
                    }
                    step--;
                }
                int x3 = x2, y3 = y2;
                step = n - 1;
                while (step > 0) {
                    if (x3 == row + n - 1) {
                        y3--;
                    } else {
                        x3++;
                    }
                    step--;
                }
                int x4 = x3, y4 = y3;
                step = n - 1;
                while (step > 0) {
                    if (y4 == row) {
                        x4--;
                    } else {
                        y4--;
                    }
                    step--;
                }
                System.out.println("");
                // 交换
                swap(matrix, x1, y1, x2, y2);
                swap(matrix, x3, y3, x4, y4);
                swap(matrix, x1, y1, x3, y3);
            }
            row++;
            col++;
            n -= 2;
        }
    }

    private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[][] matrix = createMatrix(4, 4, 5, 1, 9, 11, 2, 4, 8, 10, 13, 3, 6, 7, 15, 14, 12, 16);
        rotate(matrix);
        showMatrix(matrix);
    }
}
