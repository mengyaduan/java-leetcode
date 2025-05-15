package Lc119;

import org.testng.annotations.Test;

import java.util.PriorityQueue;

public class LCR076 {
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
        int[] n = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(n, 4));

    }
}
