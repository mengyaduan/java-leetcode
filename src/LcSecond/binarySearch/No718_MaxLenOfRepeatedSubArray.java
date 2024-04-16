package LcSecond.binarySearch;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/">找到最长的相同子数组</a>
 **/
public class No718_MaxLenOfRepeatedSubArray {
    public int findLength(int[] nums1, int[] nums2) {
        int maxLen = 0;
        for (int j = 0; j < nums1.length; j++) {
            int left = j;
            int cur = left;
            for (int i = 0; i < nums2.length; i++) {
                if (nums2[i] == nums1[cur]) {
                    // 在当前基础上扩张
                    int x = i, y = cur;
                    while (x < nums2.length && y < nums1.length && nums2[x] == nums1[y]) {
                        x++;
                        y++;
                        maxLen = Math.max(maxLen, y - cur);
                    }
                } else {
                    cur = left;
                }
            }
        }
        return maxLen;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] n1 = new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
        int[] n2 = new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0, 0};
        System.out.println(findLength(n1, n2));

    }
}
