package lc150;

import org.testng.annotations.Test;

public class No427Construct {

    public Node construct(int[][] grid) {
        Node result = cons(grid, 0, 0, grid.length);
        return result;
    }

    private Node cons(int[][] grid, int x, int y, int size) {
        Node result = new Node(false, false);
        if (size == 1) {
            result.isLeaf = true;
            result.val = grid[x][y] == 1;
            return result;
        }
        // 如果目前范围内，全部值都一致，则可以返回；否则可以继续拆分，需要计算一下各个子网格的左上角
        int sameVal = grid[x][y];
        boolean needSplit = false;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (grid[i][j] != sameVal) {
                    needSplit = true;
                    break;
                }
            }
            if (needSplit) {
                break;
            }
        }
        if (!needSplit) {
            result.isLeaf = true;
            result.val = sameVal == 1;
            return result;
        }
        size /= 2;
        result.topLeft = cons(grid, x, y, size);
        result.topRight = cons(grid, x, y + size, size);
        result.bottomLeft = cons(grid, x + size, y, size);
        result.bottomRight = cons(grid, x + size, y + size, size);
        return result;
    }


    @Test(description = "")
    public void test() throws Exception {
        int[][] grid = {
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0}
        };
        int[][] grid2 = {
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {1, 1, 0, 0},
                {0, 0, 1, 1}
        };
        Node result = construct(grid2);
    }


    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }


}
