package LcSecond.binarySearch;

/**
 * @see <a href="https://leetcode.com/problems/search-a-2d-matrix/description/">在二维矩阵中找指定数字</a>
 **/
public class No73_SearchIn2D {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = -1;
        // 先找到小于等于target的最大行，如果找不到，直接返回false
        int l = 0, r = m - 1;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (matrix[mid][0] <= target) {
                row = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (row == -1) {
            return false;
        }
        l = 0;
        r = n - 1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

}
