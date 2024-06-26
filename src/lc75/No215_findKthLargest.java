package lc75;

import org.testng.annotations.Test;

import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/?envType=study-plan-v2&envId=leetcode-75">数组中第k大的元素</a>
 */
public class No215_findKthLargest {


    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> helper = new PriorityQueue<>();
        for (int item : nums) {
            helper.add(item);
            if (helper.size() > k) {
                helper.poll();
            }
        }
        return helper.poll();
    }

    @Test(description = "")
    public void test() throws Exception {
        PriorityQueue<Integer> help = new PriorityQueue<>((a, b) -> b - a);
        help.add(3);
        help.add(1);
        help.add(2);
        help.add(4);
        help.add(56);
        System.out.println(help.poll());
        System.out.println(help.peek());


    }
}
