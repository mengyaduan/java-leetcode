package Lc119;

import java.util.PriorityQueue;

/**
 * LCR 059
 */
public class KthLargest {

    PriorityQueue<Integer> helper;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        helper = new PriorityQueue<>();
        for (int item : nums) {
            if (helper.size() < k) {
                helper.add(item);
            } else {
                helper.add(item);
                helper.poll();
            }
        }
    }

    public int add(int val) {
        helper.add(val);
        if (helper.size() > k) {
            helper.poll();
        }
        return helper.peek();
    }


}
