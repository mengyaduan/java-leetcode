package Lc.KrahetsInterview.DynamicProgram;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/longest-increasing-subsequence/">最长增序子序列</a>
 **/
public class No300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        if (nums.length == 2) {
            return nums[0] < nums[1] ? 2 : 1;
        }
        int res = 0;
        int[] dpTable = new int[nums.length];
        Arrays.fill(dpTable, 0);
        dpTable[0] = 1;

        for (int i = 1; i < dpTable.length; i++) {
            int flag = i - 1;
            while (flag >= 0) {
                if (nums[i] > nums[flag]) {
                    dpTable[i] = Math.max(dpTable[flag] + 1, dpTable[i]);
                } else {
                    dpTable[i] = Math.max(1, dpTable[i]);
                }
                res = Math.max(res, dpTable[i]);
                flag--;
            }
        }
//        String[] x = Arrays.stream(dpTable).mapToObj(String::valueOf).toArray(String[]::new);
//        System.out.println(StringUtils.join(x, ","));
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));

    }
}
