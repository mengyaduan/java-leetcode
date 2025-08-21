package LC100Again;


import java.util.ArrayList;
import java.util.List;

public class Lc019 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int[][] memo = new int[m][n];
        int i = 0, j = 0;
        String direction = "toRight";

        while (result.size() < m * n) {
            result.add(matrix[i][j]);
            memo[i][j] = 1;
            switch (direction) {
                case "toRight":
                    j++;
                    if (j == n || memo[i][j] == 1) {
                        j--;
                        i++;
                        direction = "toBottom";
                    }
                    break;
                case "toBottom":
                    i++;
                    if (i == m || memo[i][j] == 1) {
                        i--;
                        j--;
                        direction = "toLeft";
                    }
                    break;
                case "toLeft":
                    j--;
                    if (j == -1 || memo[i][j] == 1) {
                        j++;
                        i--;
                        direction = "toUp";
                    }
                    break;
                case "toUp":
                    i--;
                    if (i == -1 || memo[i][j] == 1) {
                        i++;
                        j++;
                        direction = "toRight";
                    }
                    break;
            }
        }
        return result;
    }
}
