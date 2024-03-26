package LcSecond.binarySearch;

import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @see <a href="https://leetcode.com/problems/132-pattern/description/">是否存在值排序 132</a>
 **/
public class No456_132Pattern {

    public boolean find132pattern(int[] nums) {
        Deque<Integer> midValue = new ArrayDeque<>();
        int rightValue = Integer.MIN_VALUE;
        // 将最后一个数扔进去
        midValue.add(nums[nums.length - 1]);
        int pivot = nums.length - 2;
        while (pivot >= 0) {
            if (nums[pivot] < rightValue) {
                return true;
            }
            int curValue = nums[pivot];
            while (!midValue.isEmpty() && midValue.peekLast() < curValue) {
                rightValue = Math.max(rightValue, midValue.pollLast());
            }
            midValue.add(curValue);
            pivot--;
        }
        return false;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] nums = new int[]{-2, 1, -1};
        System.out.println(find132pattern(nums));

    }


}
