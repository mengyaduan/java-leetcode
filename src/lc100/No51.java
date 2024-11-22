package lc100;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class No51 {
    List<List<String>> result;
    int[][] used;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        used = new int[n][n];
        backtrack(n, 0);
        return result;
    }

    private void backtrack(int n, int rowNum) {
        if (rowNum == n) {
            // 成功，加入结果集
            ArrayList<String> res = new ArrayList<>();
            for (int[] row : used) {
                StringBuilder line = new StringBuilder();
                for (int item : row) {
                    line.append(item == 0 ? "." : "Q");
                }
                res.add(line.toString());
            }
            result.add(res);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[rowNum][i] == 1) {
                // 已经用过了，跳过
                continue;
            }
            if (!canBeQueen(rowNum, i, n)) {
                // 如果和已经存在的冲突，跳过
                continue;
            }
            used[rowNum][i] = 1;
            backtrack(n, rowNum + 1);
            used[rowNum][i] = 0;
        }
    }

    private boolean canBeQueen(int rowNum, int idx, int length) {
        // 垂直向上
        for (int i = 0; i < rowNum; i++) {
            if (used[i][idx] == 1) {
                return false;
            }
        }
        // 左斜上
        int m = rowNum - 1, n = idx - 1;
        while (m >= 0 && n >= 0) {
            if (used[m][n] == 1) {
                return false;
            }
            m--;
            n--;
        }
        // 右斜上
        m = rowNum - 1;
        n = idx + 1;
        while (m >= 0 && n < length) {
            if (used[m][n] == 1) {
                return false;
            }
            m--;
            n++;
        }
        return true;
    }


    @Test(description = "")
    public void test() throws Exception {
        System.out.println(solveNQueens(1));
        System.out.println(solveNQueens(4));

    }
}
