package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @see <a href="https://leetcode.com/problems/constrained-subsequence-sum/?show=1">带限制的子序列和</a>
 **/
public class No1425 {

    /**
     * 状态转移方程：<p>
     * dp(0) = nums[0];<p>
     * dp(n) = max(nums[n], nums[n]+dp(n-1), nums[n]+dp(n-2)...nums[n]+dp(n-k));<p>
     * 前n个dp明显可以通过滑动窗口控制，且因为计算最大值，可以使用单调队列来实现。
     **/


    public int constrainedSubsetSum(int[] nums, int k) {
        int[] dp = Arrays.copyOf(nums, nums.length);
        int sumMax = dp[0];
        MonotonicQueue monotonicQueue = new MonotonicQueue();
        monotonicQueue.push(dp[0]);

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + monotonicQueue.max());
            sumMax = Math.max(sumMax, dp[i]);
            if (i < k) {
                monotonicQueue.push(dp[i]);
            } else {
                monotonicQueue.pop(dp[i - k]);
                monotonicQueue.push(dp[i]);
            }
        }
        return sumMax;
    }


    class MonotonicQueue {
        LinkedList<Integer> maxq = new LinkedList<>();

        public void push(int n) {
            while (!maxq.isEmpty() && maxq.getLast() < n) {
                maxq.pollLast();
            }
            maxq.addLast(n);
        }

        public int max() {
            return maxq.peekFirst();
        }

        public void pop(int n) {
            if (n == maxq.peekFirst()) {
                maxq.pollFirst();
            }
        }
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{100, -10, -10, -10, -2, -2, -10, -100, 15, -5, -10, 10, 2, -10, 5, 20}, 2, 125},
                // 100, 90, 90, 80, 88, 86, 78, -14, 93, 88, 83, 98, 100,90,105,125
                {new int[]{10}, 1, 10},
                {new int[]{-10}, 1, -10},
                {new int[]{5, -10}, 1, 5},
                {new int[]{5, -10}, 2, 5},
                {new int[]{10, -2, -10, -5, 20}, 2, 23},
                {new int[]{-10, -5, 20}, 2, 20},
                {new int[]{20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10}, 19, 20},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] nums, int k, int expected) {
        int res = constrainedSubsetSum(nums, k);
        Assert.assertEquals(res, expected);
    }


}
