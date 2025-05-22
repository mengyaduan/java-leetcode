package Lc119;

import org.testng.annotations.Test;

public class LCR092 {

    public int minFlipsMonoIncr(String s) {
        int result = Integer.MAX_VALUE;
        char[] sc = s.toCharArray();
        int[] preSum = new int[sc.length];
        // 计算前缀和
        preSum[0] = sc[0] == '0' ? 0 : 1;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + (sc[i] == '0' ? 0 : 1);
        }
        // 遍历所有分割点，找最小值
        for (int i = 0; i < preSum.length; i++) {
            // 0,1,2,3,4,5
            // 1,0,1,1,0,1
            // 1,1,2,3,3,4
            int left = preSum[i] - (sc[i] == '0' ? 0 : 1);
            int right = (preSum.length - 1 - i) - (preSum[preSum.length - 1] - preSum[i]);
            result = Math.min(result, left + right);
        }
        return result;
    }


    @Test(description = "")
    public void test() throws Exception {
        System.out.println(minFlipsMonoIncr("00110"));
        System.out.println(minFlipsMonoIncr("00011000"));
        System.out.println(minFlipsMonoIncr("100000001010000"));

    }
}
