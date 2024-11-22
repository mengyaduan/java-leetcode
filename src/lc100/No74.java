package lc100;

public class No74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 二分找到行
        int l = 0, r = m - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int item = matrix[mid][0];
            if (item == target) {
                return true;
            } else if (item < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        int row = l - 1;
        l = 0;
        r = n - 1;
        // 二分找到列
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int item = matrix[row][mid];
            if (item == target) {
                return true;
            } else if (item < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
