package Lc.KrahetsInterview.Simulation;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/spiral-matrix/description/">螺旋矩阵</a>
 **/
public class No54 {
    ArrayList<Integer> res = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int total = m * n;
        int startI = 0;
        int startJ = 0;
        while (res.size() < total) {
            oneSingleRound(matrix, startI, startJ, m, n);
            startI += 1;
            startJ += 1;
            m = m - 2;
            n = n - 2;
        }
        return res;
    }

    private void oneSingleRound(int[][] matrix, int startI, int startJ, int row, int col) {
        if (row == 1) {
            for (int k = 0; k < col; k++) {
                res.add(matrix[startI][startJ + k]);
            }
            return;
        }
        if (col == 1) {
            for (int k = 0; k < row; k++) {
                res.add(matrix[startI + k][startJ]);
            }
            return;
        }
        // 从起点往右走，走列数
        int i = 0;
        int j = 0;
        for (j = 0; j < col; j++) {
            res.add(matrix[startI][startJ + j]);
        }
        // 走到头以后，往下转
        for (i = 1; i < row; i++) {
            res.add(matrix[startI + i][startJ + col - 1]);
        }
        // 走到头以后，向左转
        for (j = startJ + col - 1 - 1; j >= startJ; j--) {
            res.add(matrix[startI + row - 1][j]);
        }
        // 走到startJ后，先上转
        for (i = startI + row - 1 - 1; i > startI; i--) {
            res.add(matrix[i][startJ]);
        }
    }

    @Test(description = "单测")
    public void test() {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };
        int[][] matrix2 = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 20}
        };
        int[][] matrix3 = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8},
        };
        int[][] matrix4 = {
                {1},
                {3},
                {5},
                {7},
        };
        int[][] matrix5 = {
                {1, 2, 3, 4},
        };

        List<Integer> x = spiralOrder(matrix);
        res =new ArrayList<>();
        List<Integer> y = spiralOrder(matrix2);
        res =new ArrayList<>();
        List<Integer> z = spiralOrder(matrix3);
        res =new ArrayList<>();
        List<Integer> u = spiralOrder(matrix4);
        res =new ArrayList<>();
        List<Integer> v = spiralOrder(matrix5);
//        res = new ArrayList<>();
//        oneSingleRound(matrix2, 0, 0, 2, 5);
//        res = new ArrayList<>();
//        oneSingleRound(matrix3, 0, 0, 4, 2);
//        res = new ArrayList<>();
//        oneSingleRound(matrix4, 0, 0, 4, 1);
//        res = new ArrayList<>();
//        oneSingleRound(matrix5, 0, 0, 1, 4);


    }

}

