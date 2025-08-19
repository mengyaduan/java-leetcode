package LC100Again;


import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static DataStruct.tools.printIntArray;

public class Lc011 {


    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> helper = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // 如果当前窗口大于k了，则将头部弹出
            while (!helper.isEmpty() && i - helper.peekFirst() + 1 > k) {
                helper.pollFirst();
            }
            // 单调性
            while (!helper.isEmpty() && nums[helper.peekLast()] <= nums[i]) {
                helper.pollLast();
            }
            helper.addLast(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[helper.peekFirst()];
            }
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {

        printIntArray(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));

    }

}
