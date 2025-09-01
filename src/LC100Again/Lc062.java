package LC100Again;


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc062 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] col = new int[n];
        // 左下到右上
        int[] sum = new int[2 * n - 1];
        // 左上到右下
        int[] sub = new int[2 * n - 1];
        solve(0, col, sum, sub, new ArrayList<>(), result);

        return result;
    }

    private void solve(int i, int[] col, int[] sum, int[] sub, ArrayList<String> path, List<List<String>> result) {
        if (i == col.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        int n = col.length;
        for (int j = 0; j < n; j++) {
            // 检查当前位置能不能放
            if (col[j] == 1 || sum[i + j] == 1 || sub[j - i + n - 1] == 1) {
                continue;
            }
            // 当前位置可放，更新数据，开始遍历下一行
            col[j] = 1;
            sum[i + j] = 1;
            sub[j - i + n - 1] = 1;
            path.add(putQ(n, j));
            solve(i + 1, col, sum, sub, path, result);
            col[j] = 0;
            sum[i + j] = 0;
            sub[j - i + n - 1] = 0;
            path.remove(path.size() - 1);
        }
    }

    private String putQ(int n, int j) {
        char[] array = new char[n];
        Arrays.fill(array, '.');
        array[j] = 'Q';
        return new String(array);
    }

    @Test(description = "")
    public void test() throws Exception {

        System.out.println(solveNQueens(4));

    }

}
