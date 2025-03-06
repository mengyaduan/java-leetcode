package lc150;

import org.testng.annotations.Test;

public class No52TotalNQueens {


    int result;
    /**
     * 从上到下
     */
    int cols[];
    /**
     * 左上到右下
     */
    int leftSlash[];
    /**
     * 左下到右上
     */
    int rightSlash[];

    public int totalNQueens(int n) {
        result = 0;
        // 初始化所有记录
        cols = new int[n];
        leftSlash = new int[2 * n - 1];
        rightSlash = new int[2 * n - 1];
        // 回溯可行性
        backtrack(n, 0);
        return result;
    }

    private void backtrack(int n, int x) {
        // 终止条件
        if (x == n) {
            // 已经排完n行了
            result++;
            return;
        }
        for (int i = 0; i < n; i++) {
            // 检查当前位置是否可以放置
            boolean idle = cols[i] == 0 && leftSlash[x - i + n - 1] == 0 && rightSlash[x + i] == 0;
            if (!idle) {
                continue;
            }
            // 放置，并更新棋盘
            cols[i] = 1;
            leftSlash[x - i + n - 1] = 1;
            rightSlash[x + i] = 1;
            // 往下探索
            backtrack(n, x + 1);
            // 取消放置，更新棋盘
            cols[i] = 0;
            leftSlash[x - i + n - 1] = 0;
            rightSlash[x + i] = 0;
        }
    }

    @Test(description = "")
    public void test() throws Exception {
//        System.out.println(totalNQueens(1));
//        System.out.println(totalNQueens(2));
        System.out.println(totalNQueens(4));

    }


}
