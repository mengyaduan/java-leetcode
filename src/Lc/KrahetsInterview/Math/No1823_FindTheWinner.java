package Lc.KrahetsInterview.Math;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/find-the-winner-of-the-circular-game/description/?envType=study-plan-v2&envId=selected-coding-interview">找出胜利者</a>
 **/
public class No1823_FindTheWinner {

    public int findTheWinner(int n, int k) {
        int lastOne = 0;
        for (int i = 2; i <= n; i++) {
            lastOne = (lastOne + k) % i;
        }
        return lastOne + 1;
    }

    public int findTheWinnerRecur(int n, int k) {
        return dp(n, k) + 1;
    }

    public int dp(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (dp(n - 1, k) + k) % n;
    }


    @Test(description = "")
    public void test() throws Exception {
        System.out.println(findTheWinner(5, 1));
        System.out.println(findTheWinner(5, 2));
        System.out.println(findTheWinner(5, 3));
        System.out.println(findTheWinner(5, 4));
        System.out.println(findTheWinner(5, 5));

    }

}

