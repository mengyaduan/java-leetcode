package lc100;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class No54 {

    List<Integer> result;
    int[] rows;
    int[] cols;
    int right = 0b0001;
    int down = 0b0010;
    int left = 0b0100;
    int up = 0b1000;
    int direction;

    public List<Integer> spiralOrder(int[][] matrix) {
        result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        rows = new int[m];
        cols = new int[n];
        direction = right;
        result.add(matrix[0][0]);
        traverse(matrix, 0, 0);
        return result;
    }

    private void traverse(int[][] matrix, int i, int j) {
        if (rows[i] == 1 && cols[j] == 1) {
            return;
        }
        // 如果是横向移动，先标记行，否则先标记列
        if ((direction ^ right) == 0 || (direction ^ left) == 0) {
            rows[i] = 1;
        }
        if ((direction ^ up) == 0 || (direction ^ down) == 0) {
            cols[j] = 1;
        }
        if ((direction ^ right) == 0) {
            while (j + 1 < matrix[0].length && cols[j + 1] != 1) {
                result.add(matrix[i][j + 1]);
                j++;
            }
            direction = down;
        } else if ((direction ^ left) == 0) {
            while (j - 1 >= 0 && cols[j - 1] != 1) {
                result.add(matrix[i][j - 1]);
                j--;
            }
            direction = up;
        } else if ((direction ^ down) == 0) {
            while (i + 1 < matrix.length && rows[i + 1] != 1) {
                result.add(matrix[i + 1][j]);
                i++;
            }
            direction = left;
        } else if ((direction ^ up) == 0) {
            while (i - 1 >= 0 && rows[i - 1] != 1) {
                result.add(matrix[i - 1][j]);
                i--;
            }
            direction = right;
        }
        traverse(matrix, i, j);
    }

    @Test(description = "")
    public void test() throws Exception {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        List<Integer> x = spiralOrder(matrix);
        System.out.println(StringUtils.join(x, ","));
    }
}
