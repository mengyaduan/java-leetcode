package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/burst-balloons/">戳气球</a>
 **/
public class No312 {
    //这是一个求最值的问题，所以我们考虑使用动态规划来解决这个问题
    public int maxCoins(int[] nums) {
        int n = nums.length;
        //为什么用n+2呢？意思就是把最左边和最右边这两个实际上没有的气球加进来，是模拟的气球
        int[] points = new int[n + 2];
        //因为虚拟气球的值为1，所以我们给它进行赋值
        points[0] = points[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            points[i] = nums[i - 1];
        }
        //上面的步骤完成之后，我们的这个points数组中就是我们的所有的气球的值，包括我们自己加的两个虚拟气球

        //dp 数组的定义：dp[i][j]表示戳破（i,j）之间的气球可以得到的最大金币，注意是开区间，左右两端是不会戳破的
        int[][] dp = new int[n + 2][n + 2];

        //base case:当j<i的时候，肯定是不合法的，所以dp数组此时为0
        //虽然这个base case可以省略的，但是写在这里更加好理解点
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < i; j++) {
                dp[i][j] = 0;
            }
        }
        //状态转移：当最后戳破的气球是k这个位置的气球的话，我们可以获得的最多的金币是，dp[i][k]+dp[k][j]+points[i]*points[k]*points[j]
        //意思就是戳完左边的最大金币+戳破右边气球的最大金币+最后这个戳破气球的金币

        //遍历的方向，一般就是从base case出发。然后向最后结果靠拢
        for (int i = n; i >= 0; i--) {
            for (int j = i + 1; j < n + 2; j++) {
                //k就是最后戳破的气球的位置，k肯定是在i和j之间的
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i] * points[k] * points[j]);
                }
            }
        }
        return dp[0][n + 1];
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{1, 5}, 10},
                {new int[]{3, 1, 5, 8}, 167},
                {new int[]{9, 76, 64, 21, 97}, 669494},
                {new int[]{8, 2, 6, 8, 9, 8, 1, 4, 1, 5, 3, 0, 7, 7, 0, 4, 2, 2, 5}, 3630}

        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] nums, int expected) {
        int res = maxCoins(nums);
        Assert.assertEquals(res, expected);
    }

}
