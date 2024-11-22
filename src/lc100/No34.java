package lc100;

import org.testng.annotations.Test;

import static DataStruct.tools.printIntArray;

public class No34 {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                result[0] = mid;
                r = mid - 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                result[1] = mid;
                l = mid + 1;
            } else if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        printIntArray(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
        printIntArray(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 7));

    }
}
