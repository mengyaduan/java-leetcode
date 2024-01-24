package Lc.KrahetsInterview.DynamicProgram;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/longest-alternating-subarray/description/">最长交替子数组</a>
 **/
public class No2765 {

    public int alternatingSubarray(int[] nums) {
        int lengthPrevious = 0;
        int res = -1;
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff != 1 && diff != -1) {
                // 不符合差值的数字直接跳过，给-1
                lengthPrevious = -1;
                continue;
            }
            // 前一位长度是偶数的时候，需要-1；前一位长度是奇数的时候，需要1
            int needOne = lengthPrevious % 2 == 0 ? -1 : 1;
            if (lengthPrevious > 0 && diff == needOne) {
                //  处于规则子数组(length>0) 且 满足交替规则时，length++
                lengthPrevious++;
            } else {
                // 不在规则子数组中（length==-1）或者 不满足交替规则时，重新处理length
                // 如果是1，成为子数组起点，如果是-1，length归-1
                if (diff == 1) {
                    lengthPrevious = 2;
                }
                if (diff == -1) {
                    lengthPrevious = -1;
                }
            }
            res = Math.max(lengthPrevious, res);
        }
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(alternatingSubarray(new int[]{14, 30, 29, 49, 3, 23, 44, 21, 26, 52}));
        System.out.println(alternatingSubarray(new int[]{4, 5, 6}));

    }


}

