package lc75;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/domino-and-tromino-tiling/?envType=study-plan-v2&envId=leetcode-75">多米诺和托米诺平铺</a>
 */
public class No790_numTilings {

    public int numTilings(int n) {
        int m = 1000000007;
        int[][] memo = new int[n + 1][4];
        memo[0][0] = 0;
        memo[0][1] = 0;
        memo[0][2] = 0;
        memo[0][3] = 1;
        for (int i = 1; i < n + 1; i++) {
            memo[i][0] = memo[i - 1][3] % m;
            memo[i][1] = (memo[i - 1][0] + memo[i - 1][2]) % m;
            memo[i][2] = (memo[i - 1][0] + memo[i - 1][1]) % m;
            memo[i][3] = ((memo[i - 1][0] + memo[i - 1][1]) % m + (memo[i - 1][2] + memo[i - 1][3]) % m) % m;
        }
        return memo[n][3];
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(numTilings(1));
        System.out.println(numTilings(2));
        System.out.println(numTilings(3));
        System.out.println(numTilings(5));
        System.out.println(numTilings(15));

    }


}
