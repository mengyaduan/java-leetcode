package LC100Again;


import org.testng.annotations.Test;

import java.util.PriorityQueue;

public class Lc074 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int item : nums) {
            priorityQueue.offer(item);
            if (priorityQueue.size() == k + 1) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }

    @Test(description = "")
    public void test() throws Exception {

        System.out.println(findKthLargest(new int[]{1, 2, 3, 4, 5, 6, 5}, 1));

    }


}
