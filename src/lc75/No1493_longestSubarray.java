package lc75;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/description/?envType=study-plan-v2&envId=leetcode-75">删掉一个元素以后全为1的最长子数组</a>
 */
public class No1493_longestSubarray {
    // 包含至多1个0的最长子数组
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = nums.length;
        boolean hasZero = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (!hasZero) {
                    hasZero = true;
                } else {
                    right = i;
                    break;
                }
            }
        }
        int res = right - left - 1;
        while (right < nums.length) {
            int tmp = right + 1;
            while (tmp < nums.length && nums[tmp] != 0) {
                tmp++;
            }
            right = tmp;
            while (nums[left] != 0) {
                left++;
            }
            left++;
            res = Math.max(res, right - left - 1);

        }
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(longestSubarray(new int[]{1, 0, 1, 0}));
        System.out.println(longestSubarray(new int[]{0, 1, 0, 1}));
        System.out.println(longestSubarray(new int[]{0, 0, 0, 0}));
        System.out.println(longestSubarray(new int[]{1, 1, 1, 1}));
        System.out.println(longestSubarray(new int[]{1, 1, 0, 1}));

    }
}
