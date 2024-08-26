package lc150;

/**
 * @see <a href="https://leetcode.cn/problems/search-insert-position/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No35SearchInsert {


    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return  l;
    }
}
