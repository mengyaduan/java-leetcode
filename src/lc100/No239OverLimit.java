package lc100;

import org.testng.annotations.Test;

import java.util.PriorityQueue;

import static DataStruct.tools.printIntArray;

public class No239OverLimit {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> helper = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k - 1; i++) {
            helper.offer(nums[i]);
        }
        int right = k - 1;
        int left = 0;
        while (right < nums.length) {
            helper.add(nums[right]);
            result[left] = helper.peek();
            helper.remove(nums[left]);
            left++;
            right++;
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        printIntArray(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
        printIntArray(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 7));
        printIntArray(maxSlidingWindow(new int[]{1}, 1));

    }
}
