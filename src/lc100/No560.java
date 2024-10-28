package lc100;

import org.testng.annotations.Test;
import sun.font.CreatedFontTracker;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.IntStream;

public class No560 {


    public int subarraySum(int[] nums, int k) {
        int result = 0;
        HashMap<Integer, Integer> helper = new HashMap<>();
        int[] preSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                preSum[i] = nums[0];
            } else {
                preSum[i] = preSum[i - 1] + nums[i];
            }
            helper.put(preSum[i], helper.getOrDefault(preSum[i], 0) + 1);
        }
        for (int i = -1; i < preSum.length; i++) {
            if (i == -1) {
                int targetCount = helper.getOrDefault(k, 0);
                targetCount = Math.max(targetCount, 0);
                result += targetCount;
                continue;
            }
            // 先将当前值弹出，看后续还有多少满足需求的，以此避免重复计算
            int count = helper.getOrDefault(preSum[i], 0);
            helper.put(preSum[i], count - 1);
            int targetCount = helper.getOrDefault(preSum[i] + k, 0);
            targetCount = Math.max(targetCount, 0);
            result += targetCount;
        }
        return result;
    }


    @Test(description = "")
    public void test() throws Exception {
        System.out.println(subarraySum(new int[]{1, 2, 1, 2, 1}, 3));
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{0, 0, 0}, 0));
        System.out.println(subarraySum(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 0));
    }
}