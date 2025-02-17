package LcSpring100;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class No493ReversePairsOverLimit {

    public int reversePairs(int[] nums) {
        int result = 0;
        PriorityQueue<Integer> helper = new PriorityQueue<>((a, b) -> b - a);
        for (int item : nums) {
            if (!helper.isEmpty()) {
                ArrayList<Integer> store = new ArrayList<>();
                while (!helper.isEmpty() && helper.peek() - item > item) {
                    store.add(helper.poll());
                    result++;
                }
                for (int x : store) {
                    helper.offer(x);
                }
            }
            helper.offer(item);
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(reversePairs(new int[]{9, 8, 6, 7, 2, 4, 3}), 8);

    }


}
