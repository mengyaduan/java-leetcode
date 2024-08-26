package lc150;

/**
 * @see <a href="https://leetcode.cn/problems/search-a-2d-matrix/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No74SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 从左下角开始
        int startX = m - 1, startY = 0;
        while (startX >= 0 && startX < m && startY >= 0 && startY < n) {
            if (matrix[startX][startY] == target) {
                return true;
            } else if (matrix[startX][startY] > target) {
                startX--;
            } else {
                startY++;
            }
        }
        return false;
    }

}
