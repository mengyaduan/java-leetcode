package Lc.KrahetsInterview.Simulation;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @see <a href="https://leetcode.com/problems/rotate-image/description/">旋转矩阵</a>
 **/
public class No48 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int i = 0;
        while (i <= n / 2) {
            rotateOneLayer(matrix, i, i, n);
            i++;
        }
    }

    private void rotateOneLayer(int[][] matrix, int startI, int startJ, int len) {
        // 上边跟右边对掉,下边跟左边对掉，然后上下镜像
        for (int i = 0; i < len - 2 * startI - 1; i++) {
            swap(matrix, startI, startJ + i, startJ + i, len - startI - 1);
            swap(matrix, len - startI - 1, len - (startJ + i) - 1, len - (startJ + i) - 1, startI);
            swap(matrix, startI, startJ + i, len - startI - 1, len - (startJ + i) - 1);
        }
    }

    private void swap(int[][] matrix, int i, int j, int x, int y) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[x][y];
        matrix[x][y] = temp;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
//        rotateOneLayer(matrix, 0, 0, 5);
//        rotateOneLayer(matrix, 1, 1, 5);
//        rotateOneLayer(matrix, 2, 2, 1);
        rotate(matrix);
        for (int[] x : matrix) {
            String row = Arrays.stream(x)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining("\t"));
            System.out.println(row);
        }
    }
}

