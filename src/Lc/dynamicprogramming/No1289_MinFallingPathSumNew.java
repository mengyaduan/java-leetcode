package Lc.dynamicprogramming;

import org.testng.annotations.Test;

import java.util.Arrays;

import static DataStruct.tools.createMatrix;

/**
 * @see <a href="https://leetcode.cn/problems/minimum-falling-path-sum-ii/description/"></a>
 **/
public class No1289_MinFallingPathSumNew {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] memo = new int[n][n];
        // 直接赋值最后一行
        for (int i = 0; i < n; i++) {
            memo[n - 1][i] = grid[n - 1][i];
        }
        for (int i = n - 2; i >= 0; i--) {
            // 先找到指定行的最小值和次小值，然后更新本行所有数据
            valIdx[] bottomLine = getTwoMin(memo[i + 1]);
            valIdx minFirst = bottomLine[0];
            valIdx minSecond = bottomLine[1];
            for (int j = 0; j < n; j++) {
                // 如果当前值和前一行的最小值不在一列上，可以直接取和，如果在一列上，则用次小值
                if (j != minFirst.idx) {
                    memo[i][j] = grid[i][j] + minFirst.value;
                } else {
                    memo[i][j] = grid[i][j] + minSecond.value;
                }
            }
        }
        int[] firstLine = memo[0];
        return Arrays.stream(firstLine).min().getAsInt();
    }

    /**
     * 获取指定行的最小值和次小值
     *
     * @param row
     * @return
     */
    public valIdx[] getTwoMin(int[] row) {
        // x行的最小值
        valIdx minx = new valIdx();
        // x行的次小值
        valIdx secondMinx = new valIdx();
        for (int i = 0; i < row.length; i++) {
            if (row[i] <= minx.value) {
                // 如果小于当前的最小值
                secondMinx.value = minx.value;
                secondMinx.idx = minx.idx;
                minx.value = row[i];
                minx.idx = i;
            } else if (row[i] >= secondMinx.value) {
                // 如果大于当前的次小值，不需要更新
            } else {
                // 大于当前最小值，小于当前次小值，需要更新次小值
                secondMinx.value = row[i];
                secondMinx.idx = i;
            }
        }
        valIdx[] res = new valIdx[2];
        res[0] = minx;
        res[1] = secondMinx;
        return res;
    }

    class valIdx {
        int value = Integer.MAX_VALUE;
        int idx = -1;
    }


    @Test(description = "")
    public void test() throws Exception {
//        int[] randomNum = new int[25];
//        Random random = new Random();
//        for (int i = 0; i < randomNum.length; i++) {
//            randomNum[i] = random.nextInt(100);
//        }
//        int[][] matrix = createMatrix(5, 5, randomNum);
//        showMatrix(matrix);

        int[][] matrix = createMatrix(5, 5, 92, 3, 23, 87, 36, 25, 91, 98, 18, 78, 76, 40, 83, 53, 12, 87, 66, 11, 32, 60, 8, 26, 75, 23, 25);

        System.out.println(minFallingPathSum(matrix));
    }
}

