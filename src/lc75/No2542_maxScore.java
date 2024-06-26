package lc75;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.cn/problems/maximum-subsequence-score/description/?envType=study-plan-v2&envId=leetcode-75">最大子序列的分数</a>
 */
public class No2542_maxScore {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> nums2[j] - nums2[i]);

        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            sum += nums1[idx[i]];
            pq.offer(nums1[idx[i]]);
        }

        // 当前的结果
        long product = sum * nums2[idx[k - 1]];
        for (int i = k; i < n; i++) {
            // 每次加一个的时候，都是权重最小的，只要在前面找到最小的num比较就行了
            int x = nums1[idx[i]];
            int wNow = nums2[idx[i]];
            if (x > pq.peek()) {
                // 因为当前的权重一定是缩小的，所以只有价值会增加的时候，才有可能更新队列
                sum = sum - pq.poll() + x;
                pq.offer(x);
                product = Math.max(product, sum * wNow);
            }
        }
        return product;
    }


    @Test(description = "")
    public void test() throws Exception {
        int res = 1364;
        int[] num1 = new int[]{22, 5, 25, 15, 28, 1};
        int[] num2 = new int[]{22, 30, 25, 25, 9, 18};
        Assert.assertEquals(maxScore(num1, num2, 3), res);


    }

}
