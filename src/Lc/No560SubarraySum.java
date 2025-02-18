package Lc;

import java.util.HashMap;

public class No560SubarraySum {
    public int subarraySum(int[] nums, int k) {
        // 计算前缀和
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        // 遍历处理每一个值，待处理是preSum[i]，找到 preSum[i]-preSum[x] ==k的，其中x小于i
        HashMap<Integer, Integer> helper = new HashMap<>();
        helper.put(0, 1);
        int result = 0;
        for (int i = 0; i < preSum.length; i++) {
            int need = preSum[i] - k;
            if (helper.containsKey(need)) {
                result += helper.get(need);
            }
            helper.put(preSum[i], helper.getOrDefault(preSum[i], 0) + 1);
        }
        return result;
    }
}
