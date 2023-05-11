package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/out-of-boundary-paths/?show=1">No576 出界的路径数</a>
 **/
public class No576 {

    HashMap<String, Long> memo = new HashMap<>();
    long mod = 1000000007L;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        memo.clear();
        // 将边界数据全部初始化
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[] overBoundCounts = getOverBoundInfo(m, n, i, j);
                long count = 0;
                for (boolean item : overBoundCounts) {
                    if (item) {
                        count++;
                    }
                }
                memo.put(getKey(i, j, 1), count);
            }
        }
        long res = 0;
        for (int i = 1; i <= maxMove; i++) {
            long xxx = dp(m, n, i, startRow, startColumn);
//            System.out.println("i=" + i + "时，结果为=" + xxx);
            res += xxx;

        }
        return (int) (res % mod);
    }

    public long dp(int m, int n, int move, int x, int y) {
        // 任意一个越界，都不能继续往下计算
        if (move == 0) {
            return 0;
        }
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return 0;
        }
        String keyNow = getKey(x, y, move);
        if (memo.containsKey(keyNow)) {
            return memo.get(keyNow);
        }

        long res = dp(m, n, move - 1, x + 1, y)
                + dp(m, n, move - 1, x - 1, y)
                + dp(m, n, move - 1, x, y + 1)
                + dp(m, n, move - 1, x, y - 1);
        res = res % mod;
        memo.put(getKey(x, y, move), res);
        return res;
    }

    public String getKey(int x, int y, int move) {
        return String.format("%d_%d_%d", x, y, move);
    }

    public boolean[] getOverBoundInfo(int m, int n, int x, int y) {
        // up, down, left, right
        boolean[] res = new boolean[]{false, false, false, false};
        if (x - 1 < 0) {
            res[0] = true;
        }
        if (x + 1 >= m) {
            res[1] = true;
        }
        if (y - 1 < 0) {
            res[2] = true;
        }
        if (y + 1 >= n) {
            res[3] = true;
        }
        return res;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {2, 2, 2, 0, 0, 6},
                {1, 3, 3, 0, 1, 12},
                {8, 50, 23, 5, 26, 914783380},
                {36, 5, 50, 15, 3, 390153306},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int m, int n, int maxMove, int startRow, int startCol, int expected) {
        int res = findPaths(m, n, maxMove, startRow, startCol);
        Assert.assertEquals(res, expected);
    }


    @Test(description = "")
    public void testdlaksfj() throws Exception {
        System.out.println(getKey(1, 2, 2));
        int x = 408855808;
        System.out.println(x % (1000000007L));

    }


}
