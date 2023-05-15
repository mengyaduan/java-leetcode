package Lc.dynamicprogramming;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/largest-divisible-subset/?show=1">最大整除子集</a>
 **/
public class No368 {


    public List<Integer> largestDivisibleSubset(int[] nums) {
        // 0存储长度，1存储上一个坐标
        int[][] dp = new int[nums.length][2];
        for (int[] row : dp) {
            row[0] = 1;
            row[1] = -1;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    int a = dp[j][0] + 1;
                    int b = dp[i][0];
                    dp[i][0] = Math.max(a, b);
                    if (i != j && a > b) {
                        dp[i][1] = j;
                    }
                }
            }
        }

        int maxLen = 0;
        int index = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i][0] > maxLen) {
                maxLen = dp[i][0];
                index = i;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(nums[index]);
        while (dp[index][1] != -1) {
            index = dp[index][1];
            result.add(nums[index]);
        }
        return result;
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{1, 2, 3}, 4},
                {new int[]{1, 2, 4, 8}, 4},
                {new int[]{4, 8, 10, 240, 2}, 5},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] nums, int expected) {
        List<Integer> res = largestDivisibleSubset(nums);
        System.out.println(res);
    }


}
