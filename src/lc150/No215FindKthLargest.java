package lc150;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No215FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> helper = new PriorityQueue<>();
        for (int item : nums) {
            helper.offer(item);
            if (helper.size() > k) {
                helper.poll();
            }
        }
        return helper.poll();
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2), 5);

    }
}
