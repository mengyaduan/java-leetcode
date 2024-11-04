package lc100;

import org.testng.annotations.Test;

import static DataStruct.tools.showMatrix;

public class No48 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int startIdx = 0;
        while (n > 1) {
            // 一共要处理n-1组数字，每组数字是4个数，顺时针a,b,c,d
            for (int i = 0; i < n - 1; i++) {
                // ab互换，cd互换，然后ac互换
                // 每一圈的起点一定是(start, start)
                dealWith(matrix, n, startIdx, i);
            }
            startIdx++;
            n -= 2;
        }
    }

    /**
     * @param matrix
     * @param n
     * @param start    起点，举例x,x 的位置
     * @param distance
     */
    private void dealWith(int[][] matrix, int n, int start, int distance) {
        int x = start, y = start + distance;
        int[] a = new int[]{x, y};
        int[] b = new int[]{x + distance, y + n - 1 - distance};
        int[] c = new int[]{x + n - 1, y + n - 1 - distance - distance};
        int[] d = new int[]{x + n - 1 - distance, y - distance};
        swapPoints(matrix, a, b);
        swapPoints(matrix, c, d);
        swapPoints(matrix, a, c);
    }

    private void swapPoints(int[][] matrix, int[] a, int[] b) {
        int temp = matrix[a[0]][a[1]];
        matrix[a[0]][a[1]] = matrix[b[0]][b[1]];
        matrix[b[0]][b[1]] = temp;
    }


    @Test(description = "")
    public void test() throws Exception {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(matrix2);
        showMatrix(matrix2);
    }


}
