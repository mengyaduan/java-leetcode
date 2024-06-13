package lc75;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&envId=leetcode-75">k和数对的最大数目</a>
 */
public class No1679_maxOperations {
    public int maxOperations(int[] nums, int k) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            return nums[0] + nums[1] == k ? 1 : 0;
        }
        // 先排序，然后双指针收缩
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int res = 0;
        while (i < j) {
            if (nums[i] + nums[j] == k) {
                res++;
                i++;
                j--;
            } else if (nums[i] + nums[j] < k) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    @DataProvider(name = "unit")
    public Object[][] unit() {
        return new Object[][]{
                {new int[]{1, 2, 3, 4}, 5, 2},
                {new int[]{3, 1, 3, 4, 3}, 6, 1},
                {new int[]{3, 1}, 6, 0},
        };
    }

    @Test(description = "", dataProvider = "unit")
    public void test(int[] nums, int k, int res) throws Exception {
        Assert.assertEquals(maxOperations(nums, k), res);

    }
}
