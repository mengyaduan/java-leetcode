package LcSpring100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class No529UpdateBoard {

    public char[][] updateBoard(char[][] board, int[] click) {
        // 点到地雷，直接输
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        // 点到E，则进行地柜更新操作
        Deque<int[]> helper = new ArrayDeque<>();
        helper.add(click);
        while (!helper.isEmpty()) {
            int[] c = helper.pollFirst();
            process(board, c[0], c[1], helper);
        }
        return board;
    }

    private void process(char[][] board, int x, int y, Deque<int[]> helper) {
        int m = board.length, n = board[0].length;
        // 如果当前节点不是E，则不需要再处理了
        if (board[x][y] != 'E') {
            return;
        }
        // 先统计上下左右多少个雷
        int mines = 0;
        int[][] four = new int[][]{
                {x - 1, y},
                {x + 1, y},
                {x, y - 1},
                {x, y + 1},
                {x - 1, y - 1},
                {x - 1, y + 1},
                {x + 1, y - 1},
                {x + 1, y + 1},

        };
        for (int[] p : four) {
            if (validIndex(m, n, p[0], p[1]) && board[p[0]][p[1]] == 'M') {
                mines++;
            }
        }
        if (mines == 0) {
            // 上下左右无雷，应该改为B
            board[x][y] = 'B';
            for (int[] p : four) {
                if (validIndex(m, n, p[0], p[1])) {
                    helper.addLast(p);
                }
            }
        } else {
            // 上下左右有雷，当前节点需要改成对应的雷数
            board[x][y] = (char) ('0' + mines);
        }
    }

    private boolean validIndex(int m, int n, int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

}
