package LC100Again;


import org.testng.annotations.Test;

public class Lc067 {

    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = nums.length - 1;
        if (nums[0] <= nums[n - 1]) {
            // 完全有序，直接返回第一个
            return nums[0];
        }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int item = nums[mid];
            if (item >= nums[0]) {
                // 在左区间，如果右边还是递增的，则继续，否则可以返回
                if (mid + 1 < n && nums[mid + 1] < item) {
                    return nums[mid + 1];
                }
                l = mid + 1;
            } else {
                // 在右区间，如果左边还是递减的，则继续，否则可以返回
                if (mid - 1 >= 0 && nums[mid - 1] > item) {
                    return item;
                }
                r = mid - 1;
            }
        }
        // 实际走不到这里
        return -1;
    }


    @Test(description = "")
    public void test() throws Exception {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(findMin(new int[]{3, 4, 5}));

    }

}
