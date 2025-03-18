package Lc119;

import org.testng.annotations.Test;

import java.util.HashMap;

public class LCR010 {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length, left = 0, sum = 0, result = 0;
        int[] preSum = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                preSum[i] = nums[i];
                continue;
            }
            preSum[i] = nums[i] + preSum[i - 1];
        }
        HashMap<Integer, Integer> psCnt = new HashMap<>();
        psCnt.put(0, 1);
        for (int i = 0; i < n; i++) {
            int need = preSum[i] - k;
            if (psCnt.containsKey(need)) {
                result += psCnt.get(need);
            }
            psCnt.put(preSum[i], psCnt.getOrDefault(preSum[i], 0) + 1);
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));

    }
}
