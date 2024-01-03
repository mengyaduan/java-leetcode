package Lc.KrahetsInterview.DoublePointers;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @see <a href="https://leetcode.com/problems/sliding-window-maximum/description/">滑动窗口最大值</a>
 */
public class No239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> helper = new ArrayDeque<>();

        int[] result = new int[nums.length - k + 1];

        for (int rightSide = 0, leftSide = 1 - k; rightSide < nums.length; rightSide++, leftSide++) {
            if (leftSide > 0 && nums[leftSide - 1] == helper.peekFirst()) {
                helper.pollFirst();
            }
            // 保持升序
            while (!helper.isEmpty() && helper.peekLast() < nums[rightSide]) {
                helper.pollLast();
            }
            helper.add(nums[rightSide]);
            if (leftSide >= 0) {
                res.add(helper.peekFirst());
            }
        }
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                //
                {new int[]{1, 3, -1, -3, 5, 1, 6, 7}, 3},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] nums, int k) {
        int[] x = maxSlidingWindow(nums, k);
        List<String> ss = Arrays.stream(x).mapToObj(String::valueOf).collect(Collectors.toList());
        System.out.println(StringUtils.join(ss, ","));
    }

}

