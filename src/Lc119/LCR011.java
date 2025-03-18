package Lc119;

import org.testng.annotations.Test;

import java.util.HashMap;

public class LCR011 {

    public int findMaxLength(int[] nums) {
        int result = 0;
        // 把0看成-1，然后把问题转化为和为0的最长子数组，使用前缀和来计算
        HashMap<Integer, Integer> helper = new HashMap<>();
        // 初始化前缀和
        int[] preSum = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                preSum[i] = nums[0] == 1 ? 1 : -1;
            } else {
                preSum[i] = (nums[i] == 1 ? 1 : -1) + preSum[i - 1];
            }
        }
        helper.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            int need = preSum[i];
            if (helper.containsKey(need)) {
                // 如果存在，则更新结果
                result = Math.max(result, i - helper.get(need));
            } else {
                // 如果不存在，当前一定是指定值下，最小的坐标
                helper.put(preSum[i], i);
            }
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(findMaxLength(new int[]{1, 0, 1, 1, 0, 1}));
        System.out.println(findMaxLength(new int[]{1, 0, 1}));
        System.out.println(findMaxLength(new int[]{1, 0}));
        System.out.println(findMaxLength(new int[]{0, 1}));

    }

}
