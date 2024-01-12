package Lc.KrahetsInterview.Search;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

import static DataStruct.tools.string2IntArray;

/**
 * @see <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/description/">找到第K大的数</a>
 **/
public class No215OverLimit {

    public int findKthLargest(int[] nums, int k) {
        Deque<Integer> helper = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            add2Q(helper, nums[i], k);
        }
        System.out.println(helper.peekLast());
        return helper.peekLast();
    }

    private void add2Q(Deque<Integer> helper, int num, int k) {
        Stack<Integer> stack = new Stack<>();
        while (!helper.isEmpty() && helper.peekLast() < num) {
            stack.add(helper.pollLast());
        }
        if (helper.size() < k) {
            helper.add(num);
        }
        while (!stack.isEmpty() && helper.size() < k) {
            helper.add(stack.pop());
        }
    }


    @Test(description = "")
    public void test() throws Exception {
        int[] nums = string2IntArray("3,2,1,5,6,4");
        int res = findKthLargest(nums, 2);
        Assert.assertEquals(res, 5);

    }

}

