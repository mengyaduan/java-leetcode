package Lc119;

import org.testng.annotations.Test;

public class LCR069 {

    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int l = 1, r = n - 2;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < arr[mid + 1]) {
                l = mid + 1;
            } else {
                ans = mid;
                r = mid - 1;
            }
        }
        return ans;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] arr = new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
        System.out.println(peakIndexInMountainArray(arr));
        int[] arr2 = new int[]{0, 10, 5, 2};
        System.out.println(peakIndexInMountainArray(arr2));

    }


}
