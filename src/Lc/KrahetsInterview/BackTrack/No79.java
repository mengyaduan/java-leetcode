package Lc.KrahetsInterview.BackTrack;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/word-search/description/">单词搜索</a>
 **/
public class No79 {

    int[][] memo;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, 0);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean res = backtrack(board, m, n, i, j, word, 0);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, int m, int n, int i, int j, String word, int charAt) {
        if (charAt == word.length()) {
            return true;
        }
        if (i < 0 || i >= m || j < 0 || j >= n || memo[i][j] == 1) {
            return false;
        }
        if (board[i][j] == word.charAt(charAt)) {
            memo[i][j] = 1;
            boolean a = backtrack(board, m, n, i + 1, j, word, charAt + 1);
            boolean b = backtrack(board, m, n, i - 1, j, word, charAt + 1);
            boolean c = backtrack(board, m, n, i, j + 1, word, charAt + 1);
            boolean d = backtrack(board, m, n, i, j - 1, word, charAt + 1);
            memo[i][j] = 0;
            return a || b || c || d;
        }
        return false;
    }

    @Test(description = "")
    public void test() throws Exception {
        char[][] matrix = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        boolean x = exist(matrix, "ABM");
        System.out.println(x);


    }


}

