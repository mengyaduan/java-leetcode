package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/freedom-trail/">辐射4：自由之路</a>
 **/
public class No514 {
    int[][][] memo;

    public int findRotateSteps(String ring, String key) {
        memo = new int[ring.length()][key.length()][3];
        for (int[][] row : memo) {
            for (int[] row1 : row) {
                Arrays.fill(row1, -1);
            }
        }

        return dp(ring, 0, key, 0, 0);
    }

    /**
     * @param turnType 0 顺时针逆时针都可以 1 顺时针 2 逆时针
     * @return
     */
    public int dp(String ring, int i, String key, int j, int turnType) {
        if (j >= key.length()) {
            return 0;
        }
        if (memo[i][j][turnType] != -1) {
            return memo[i][j][turnType];
        }
        int stepThisRound = 0;
        if (ring.charAt(i) == key.charAt(j)) {
            // 如果当前值相等，往左右各转一下，取小值
            stepThisRound++;
            if (j != key.length() - 1) {
                // 转一下
                stepThisRound++;
            }
            int turnUnClock = stepThisRound + dp(ring, (i + 1) % ring.length(), key, j + 1, 0);
            int turnClock = stepThisRound + dp(ring, (i + ring.length() - 1) % ring.length(), key, j + 1, 0);
            int stay = 1 + dp(ring, i, key, j + 1, 0);
            memo[i][j][0] = turnClock < turnUnClock ? turnClock : turnUnClock;
            memo[i][j][0] = memo[i][j][0] < stay ? memo[i][j][0] : stay;
            memo[i][j][1] = memo[i][j][0];
            memo[i][j][2] = memo[i][j][0];
        } else {
            stepThisRound++;
            if (turnType == 0) {
                int turnClock = stepThisRound + dp(ring, (i + ring.length() - 1) % ring.length(), key, j, 1);
                int turnUnClock = stepThisRound + dp(ring, (i + 1) % ring.length(), key, j, 2);
                memo[i][j][0] = turnClock < turnUnClock ? turnClock : turnUnClock;
                memo[i][j][1] = memo[i][j][0];
                memo[i][j][2] = memo[i][j][0];
            }
            if (turnType == 1) {
                int turnClock = stepThisRound + dp(ring, (i + ring.length() - 1) % ring.length(), key, j, 1);
                memo[i][j][1] = turnClock;
            }
            if (turnType == 2) {
                int turnUnClock = stepThisRound + dp(ring, (i + 1) % ring.length(), key, j, 2);
                memo[i][j][2] = turnUnClock;
            }
        }
        return memo[i][j][turnType];
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {"g", "g", 1},
                {"god", "o", 2},
                {"god", "god", 5},
                {"godding", "gogn", 8},
                {"godding", "gd", 4},
                {"godding", "godding", 13},
                {"aaaaa", "aaaaa", 5},
                {"xrrakuulnczywjs", "jrlucwzakzussrlckyjjsuwkuarnaluxnyzcnrxxwruyr", 204},

        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String ring, String key, int expected) {
        int res = findRotateSteps(ring, key);
        Assert.assertEquals(res, expected);
    }

}
