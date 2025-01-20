package LcSpring100;

import org.testng.annotations.Test;

import java.util.PriorityQueue;

public class No215FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> helper = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            helper.add(nums[i]);
            if (helper.size() >= k) {
                helper.poll();
            }
        }
        return helper.peek();
    }

    @Test(description = "")
    public void test1() throws Exception {
        PriorityQueue<Integer> helper = new PriorityQueue<>();
        helper.add(1);
        helper.add(9);
        helper.add(8);
        helper.add(3);
        while (!helper.isEmpty()){
            System.out.println(helper.poll());
        }


    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));

    }
}
