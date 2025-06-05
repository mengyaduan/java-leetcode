package Lc119;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.HashMap;

public class LCR093 {
    int[][] memo;

    int result;

    public int lenLongestFibSubseq(int[] arr) {
        result = 0;
        int n = arr.length;
        memo = new int[n][n];
        for (int[] rows : memo) {
            Arrays.fill(rows, -1);
        }
        HashMap<Integer, Integer> helper = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            helper.put(arr[i], i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int item = arr[i] + arr[j];
                // 如果i，j后面还有能满足条件的，则将满足条件的下一个坐标录入，否则为-1
                if (helper.containsKey(item)) {
                    memo[i][j] = helper.get(item);
                }
            }
        }
        // 初始化结束，接下来计算最长路径
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (memo[i][j] == -1) {
                    continue;
                }
                int pair = 1;
                int a = i, b = j;
                while (memo[a][b] != -1) {
                    int x = a;
                    a = b;
                    b = memo[x][b];
                    pair++;
                }
                result = Math.max(result, pair + 1);
            }
        }
        return result;
    }


    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}), 5);
        Assert.assertEquals(lenLongestFibSubseq(new int[]{1, 3, 7, 11, 12, 14, 18}), 3);


    }
}
