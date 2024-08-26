package lc150;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/search-in-rotated-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No33Search {

    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int item = nums[mid];
            if (item == target) {
                return mid;
            }
            if (item >= nums[l] && item <= nums[r]) {
                // 已经在单调序列里面时
                if (item > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // 如果没有在单调序列里面，则需要判断当前值在左边还是右边
                // 5601234
                // 2345601
                if (item >= nums[l]) {
                    // 说明当前节点在后半段
                    if (target > item || (target < item && target < nums[l])) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                } else {
                    // 当前节点在前半段
                    if ((target > item && target >= nums[l]) || target < item) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
            }
        }
        return -1;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8));
        System.out.println(search(new int[]{1, 3}, 3));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));

    }
}
