package Lc119;

import bsh.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class LCR107 {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) {
                    memo[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        boolean hasChanged = true;
        // 将要更新的值
        int target = 1;
        while (hasChanged) {
            hasChanged = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 只要上下左右有target-1，就更新成target，然后更新flag
                    if (memo[i][j] == Integer.MAX_VALUE && mat[i][j] == 1 && hasTargetMinus(memo, i, j, target - 1)) {
                        memo[i][j] = target;
                        hasChanged = true;
                    }
                }
            }
            target++;
        }
        return memo;
    }

    private boolean hasTargetMinus(int[][] memo, int i, int j, int target) {
        if (i - 1 >= 0 && memo[i - 1][j] == target) {
            return true;
        }
        if (i + 1 < memo.length && memo[i + 1][j] == target) {
            return true;
        }
        if (j - 1 >= 0 && memo[i][j - 1] == target) {
            return true;
        }
        if (j + 1 < memo[0].length && memo[i][j + 1] == target) {
            return true;
        }
        return false;
    }


    @Test(description = "")
    public void test() throws Exception {
        int[][] mat = new int[][]{
//                {0, 0, 0},
//                {0, 1, 0},
//                {1, 1, 1}
                {0, 1, 1, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 1, 0}
        };
        int[][] x = updateMatrix(mat);
        for (int[] item : x) {
            System.out.println(StringUtils.join(item, ','));
        }


    }

}
