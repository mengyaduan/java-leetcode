package LC100Again;


import org.testng.annotations.Test;

public class Lc066 {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int item = nums[mid];
            if (item == target) {
                return mid;
            } else if (target >= nums[0] && item >= nums[0]) {
                // 目标在左半区间，当前在左半区间
                if (item > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if (target >= nums[0]) {
                // 目标在左半区间，当前在右半区间
                r = mid - 1;
            } else if (target < nums[0] && item < nums[0]) {
                // 目标在右半区间，当前在右半区间
                if (item > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if (target < nums[0]) {
                // 目标在右半区间，当前在左半区间
                l = mid + 1;
            }
        }
        return -1;
    }


    @Test(description = "")
    public void test() throws Exception {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));

    }

}
