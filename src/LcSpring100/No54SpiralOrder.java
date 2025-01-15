package LcSpring100;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class No54SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] visited = new int[m][n];
        int totalNodes = m * n;
        int count = 0;
        int i = 0, j = 0;
        while (count < totalNodes) {
            // →
            while (j < n && visited[i][j] != 1) {
                result.add(matrix[i][j]);
                visited[i][j] = 1;
                j++;
            }
            j -= 1;
            i += 1;
            // ↓
            while (i < m && visited[i][j] != 1) {
                result.add(matrix[i][j]);
                visited[i][j] = 1;
                i++;
            }
            i -= 1;
            j -= 1;
            // ←
            while (j >= 0 && visited[i][j] != 1) {
                result.add(matrix[i][j]);
                visited[i][j] = 1;
                j--;
            }
            i -= 1;
            j += 1;
            // ↑
            while (i >= 0 && visited[i][j] != 1) {
                result.add(matrix[i][j]);
                visited[i][j] = 1;
                i--;
            }
            j += 1;
            i += 1;
            count++;
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[][] array = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(spiralOrder(array));
    }

}
