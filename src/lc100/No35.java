package lc100;

import org.testng.annotations.Test;

public class No35 {

    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(searchInsert(new int[]{1, 3, 5, 7}, 4));
        System.out.println(searchInsert(new int[]{1, 3, 5, 7, 9}, 4));
    }
}
