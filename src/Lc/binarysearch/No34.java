package Lc.binarysearch;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/"</a>
 **/
public class No34 {

    /**
     * 解题思路：
     * 1. 二分查找，先定位到target
     * 2. 左指针右指针继续二分定位，直到 l=0||l-1!=target && r=len-1||r+1!=target
     * key:
     * 对于边界值需要注意
     **/

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] res = new int[]{-1, -1};
        if (len == 0) {
            return res;
        }
        if (len == 1) {
            if (nums[0] != target) {
                return res;
            } else {
                return new int[]{0, 0};
            }
        }
        // 左闭右开
        int start = 0;
        int end = len;
        boolean isExist = false;
        int loc = 0;
        if ((nums[start] == target) || nums[end - 1] == target) {
            isExist = true;
            loc = nums[start] == target ? start : end - 1;
        }
        int locBefore = -1;
        while (!isExist) {
            loc = (start + end) / 2;
            if (nums[loc] == target) {
                isExist = true;
                break;
            }
            if (loc == locBefore) {
                isExist = false;
                break;
            }
            int nowAt = nums[loc];
            if (nowAt > target) {
                end = loc;
            } else if (nowAt < target) {
                start = loc;
            }
            locBefore = loc;
        }
        if (!isExist) {
            return res;
        }
        int lStart = 0;
        int lEnd = loc;
        int rStart = loc;
        int rEnd = len;
        int left;
        int right;
        while (true) {
            if (lEnd == 0 || nums[lEnd - 1] != target) {
                left = lEnd;
                break;
            }
            int lMid = (lStart + lEnd) / 2;
            if (nums[lMid] == target) {
                lEnd = lMid;
            } else if (nums[lMid] < target) {
                lStart = lMid;
            }
        }

        while (true) {
            if (rStart == len - 1 || nums[rStart + 1] != target) {
                right = rStart;
                break;
            }
            int rMid = (rStart + rEnd) / 2;
            if (nums[rMid] == target) {
                rStart = rMid;
            } else if (nums[rMid] > target) {
                rEnd = rMid;
            }
        }
        return new int[]{left, right};
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{2, 2, 3, 4, 5, 5}, 1213, new int[]{-1, -1}},
                {new int[]{2}, 1, new int[]{-1, -1}},
                {new int[]{2}, 2, new int[]{0, 0}},
                {new int[]{}, 12, new int[]{-1, -1}},
                {new int[]{0, 1, 3, 4}, 2, new int[]{-1, -1}},
                {new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4}},
                {new int[]{5, 7, 7, 8, 8, 9, 9, 9, 10}, 9, new int[]{5, 7}},
                {new int[]{5, 7, 7, 8, 8, 9, 9, 9, 10}, 10, new int[]{8, 8}},
                {new int[]{5, 7, 7, 8, 8, 9, 9, 9, 10}, 5, new int[]{0, 0}},
                {new int[]{1, 3}, 1, new int[]{0, 0}},
                {new int[]{2, 2}, 1, new int[]{-1, -1}},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] nums, int target, int[] result) {
        int[] res = searchRange(nums, target);
        Assert.assertEquals(res, result);
    }
}
