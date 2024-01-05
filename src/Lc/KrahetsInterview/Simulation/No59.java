package Lc.KrahetsInterview.Simulation;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/spiral-matrix-ii/description/">螺旋矩阵2</a>
 **/
public class No59 {

    int[][] res;

    public int[][] generateMatrix(int n) {
        res = new int[n][n];
        int count = 1;
        int startI = 0;
        int startJ = 0;
        int num = n;

        while (count <= n * n) {
            count = oneSingleRound(startI, startJ, num, count);
            startI += 1;
            startJ += 1;
            num -= 2;
        }
        return res;
    }

    private int oneSingleRound(int startI, int startJ, int n, int num) {
        if (n == 1) {
            for (int k = 0; k < n; k++) {
                res[startI][startJ + k] = num++;
            }
            return num;
        }
        // 从起点往右走，走列数
        int i = 0;
        int j = 0;
        for (j = 0; j < n; j++) {
            res[startI][startJ + j] = num++;
        }
        // 走到头以后，往下转
        for (i = 1; i < n; i++) {
            res[startI + i][startJ + n - 1] = num++;
        }
        // 走到头以后，向左转
        for (j = startJ + n - 1 - 1; j >= startJ; j--) {
            res[startI + n - 1][j] = num++;
        }
        // 走到startJ后，先上转
        for (i = startI + n - 1 - 1; i > startI; i--) {
            res[i][startJ] = num++;
        }
        return num;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[][] mm = generateMatrix(5);
        for (int[] x : mm) {
//            String row = Arrays.stream(x)
//                    .mapToObj(String::valueOf)
//                    .collect(Collectors.joining("\t"));
//            System.out.println(row);
            System.out.println(StringUtils.join(x, '\t'));
        }

    }


}