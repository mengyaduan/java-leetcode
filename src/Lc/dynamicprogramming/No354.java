package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @see <a href="https://leetcode.com/problems/russian-doll-envelopes/">俄罗斯套娃信封</a>
 **/
public class No354 {


    /**
     * 先按照x升序排，相同x按照y降序排，最后对所有y，做lis就能得到结果
     * <p>
     * 状态转移方程：<p>
     * dp[n] = max(1, dp[i]+1(when nums[i]<nums[n]))
     **/

    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int[] nums = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            nums[i] = envelopes[i][1];
        }

        return lengthOfLIS(nums);
    }


    int lengthOfLIS(int[] nums) {
        int[] top = new int[nums.length];
        // 牌堆数初始化为 0
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            // 要处理的扑克牌
            int poker = nums[i];

            /***** 搜索左侧边界的二分查找 *****/
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            /*********************************/

            // 没找到合适的牌堆，新建一堆
            if (left == piles) {
                piles++;
            }
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是 LIS 长度
        return piles;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}, 3},
                {new int[][]{{1, 1}, {1, 1}, {1, 1}, {1, 1}}, 1},
                {new int[][]{{30, 50}, {12, 2}, {3, 4}, {12, 15}}, 3},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[][] envelopes, int expected) {
        int res = maxEnvelopes(envelopes);
        Assert.assertEquals(res, expected);
    }


}
