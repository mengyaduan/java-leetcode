package Lc.search;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/search-a-2d-matrix-ii/">no240</a>
 **/
public class No240 {


    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        boolean res = false;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                j -= 1;
            } else {
                i += 1;
            }
        }
        return res;
    }


    public boolean searchMatrixSlow(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 选择m，n中最长的进行扩展
        int len = m > n ? m : n;
        // 找到target的上下边界，即对角线元素
        int i = 0;
        int cornerL = getCorner(matrix, m, n, i);
        if (cornerL > target) {
            return false;
        }
        int cornerR = 0;
        while (i < len) {
            cornerL = getCorner(matrix, m, n, i);
            cornerR = getCorner(matrix, m, n, i + 1);
            if (cornerL == target || cornerR == target) {
                return true;
            }
            if (cornerL < target && cornerR > target) {
                break;
            }
            if (cornerL > target) {
                // 目标比当前最小值还小，直接返回错误
                return false;
            }
            if (i >= m || i >= n) {
                break;
            }
            i++;
        }
        System.out.println(i);
        // 遍历：从matrix[0][i+1~n]...matrix[i][i+1~n]
        // 遍历：从matrix[i+1][0~i+1]...matrix[m][0~i+1]

        for (int j = 0; j < i + 1; j++) {
            for (int k = i + 1; k < n; k++) {
                if (matrix[j][k] == target) {
                    return true;
                }
                if (matrix[j][k] > target) {
                    break;
                }
            }
        }
        for (int j = i + 1; j < m; j++) {
            for (int k = 0; k < i + 1; k++) {
                if (matrix[j][k] == target) {
                    return true;
                }
                if (matrix[j][k] > target) {
                    break;
                }
            }

        }
        return false;
    }


    public boolean searchMatrixBasic(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 查询上限
        int wall = n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < wall; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
                if (matrix[i][j] > target) {
                    wall = j;
                    break;
                }
            }
        }
        return false;
    }

    /**
     * 获取对角线上的数据，即使不够方阵，也用无穷大填充
     *
     * @param matrix
     * @param m
     * @param n
     * @param i
     * @return
     */
    public int getCorner(int[][] matrix, int m, int n, int i) {
        if (i < m && i < n) {
            return matrix[i][i];
        } else {
            return Integer.MAX_VALUE;
        }
    }

    @Test(description = "")
    public void testhello() throws Exception {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};

        int[][] matrix2 = new int[][]{
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17},
                {18, 21, 23, 26}};
        int[][] matrix3 = new int[][]{{-1, 3}};

        System.out.println(searchMatrix(matrix3, 3));

    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        int i = 0;
        Object[][] data = {
                {i++, new int[][]{
                        {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}}, 20, false},
                {i++, new int[][]{
                        {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}}, 5, true},
                {i++, new int[][]{
                        {1, 4, 7, 11},
                        {2, 5, 8, 12},
                        {3, 6, 9, 16},
                        {10, 13, 14, 17},
                        {18, 21, 23, 26}}, 14, true},
                {i++, new int[][]{
                        {1, 4, 7, 11},
                        {2, 5, 8, 12},
                        {3, 6, 9, 16},
                        {10, 13, 14, 17},
                        {18, 21, 23, 26}}, 44, false},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int index, int[][] matrix, int target, boolean expected) {
        System.out.println(index);
        boolean res = searchMatrix(matrix, target);
//        res = searchMatrixBasic(matrix, target);
        Assert.assertEquals(res, expected);
    }
}
