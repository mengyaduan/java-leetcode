package LcSecond.binarySearch;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/h-index-ii/description/">H指数</a>
 **/
public class No275_HIndexII {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int l = 0, r = len - 1;
        int mid = 0;
        int ans = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            int number = len - mid;
            int score = citations[mid];
            if (score > number) {
                // 如果分数大于number了，左边二分
                ans = Math.max(ans, number);
                r = mid - 1;
            } else if (score < number) {
                ans = Math.max(ans, score);
                l = mid + 1;
            } else {
                return score;
            }
        }
        return ans;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(hIndex(new int[]{1, 2, 3, 5, 6, 7}), 3);
        Assert.assertEquals(hIndex(new int[]{12}), 1);
        Assert.assertEquals(hIndex(new int[]{0, 1, 3, 5, 6}), 3);
        Assert.assertEquals(hIndex(new int[]{1, 3, 5, 100}), 3);

    }
}

