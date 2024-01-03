package Lc.KrahetsInterview.DoublePointers;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @see <a href="https://leetcode.com/problems/sliding-window-maximum/description/">滑动窗口最大值</a>
 */
public class No239OverLimit {

    /**
     * 用了大顶堆，但是超时了
     **/

    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> helper = new PriorityQueue<>((a, b) -> b - a);
        // 初始化窗口
        for (int i = 0; i < k; i++) {
            helper.add(nums[i]);
        }
        res.add(helper.peek());
        // 右移
        for (int i = k; i < nums.length; i++) {
            helper.remove(nums[i - k]);
            helper.add(nums[i]);
            res.add(helper.peek());
        }
        int[] result = new int[res.size()];
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

