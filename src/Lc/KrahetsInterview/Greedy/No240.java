package Lc.KrahetsInterview.Greedy;

/**
 * @see <a href=""></a>
 **/
public class No240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 从左下角开始找
        int i = m - 1;
        int j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}

