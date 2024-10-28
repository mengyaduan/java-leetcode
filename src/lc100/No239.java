package lc100;

import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static DataStruct.tools.printIntArray;

public class No239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> helper = new ArrayDeque<>();
        for (int i = 0; i < k - 1; i++) {
            addTail(helper, nums[i]);
        }
        for (int i = k - 1; i < nums.length; i++) {
            addTail(helper, nums[i]);
            int left = i - (k - 1);
            result[left] = helper.peekFirst();
            removeHead(helper, nums[left]);
        }
        return result;
    }

    /**
     * 将队列尾部所有小于num的，都删除
     */
    private void addTail(Deque<Integer> helper, int num) {
        while (!helper.isEmpty() && helper.peekLast() < num) {
            helper.pollLast();
        }
        helper.addLast(num);
    }

    /**
     * 只有头部与待删除数据相等时才需要操作
     */
    private void removeHead(Deque<Integer> helper, int num) {
        if (!helper.isEmpty() && helper.peek() == num) {
            helper.pollFirst();
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        printIntArray(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
        printIntArray(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 7));
        printIntArray(maxSlidingWindow(new int[]{1}, 1));

    }
}
