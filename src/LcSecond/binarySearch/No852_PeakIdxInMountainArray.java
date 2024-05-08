package LcSecond.binarySearch;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/peak-index-in-a-mountain-array/">找到峰值</a>
 */
public class No852_PeakIdxInMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        // arr.length()>=3，处理两端
        if (arr[0] > arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] > arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int l = 1, r = arr.length - 2;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] < arr[mid - 1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    @Test(description = "")
    public void testUnit() throws Exception {
        int[] arr = new int[]{0, 10, 5, 2};
        Assert.assertEquals(peakIndexInMountainArray(arr), 1);

        arr = new int[]{0, 5, 2};
        Assert.assertEquals(peakIndexInMountainArray(arr), 1);

        arr = new int[]{0, 1, 2};
        Assert.assertEquals(peakIndexInMountainArray(arr), 2);

        arr = new int[]{19, 11, 2};
        Assert.assertEquals(peakIndexInMountainArray(arr), 0);
    }
}
