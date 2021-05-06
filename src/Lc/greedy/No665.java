package Lc.greedy;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/non-decreasing-array/"></>
 **/
public class No665 {

    /**
     * 思路：
     * 1. 因为目标是非降序的，所有从0到len-1遍历
     * 2. 每次取3个数，看排序，一共3种情况：
     * - i. 非降序，continue
     * - ii. 严格降序，return false
     * - iii. 升降混合，需要将三个数调整成最扁的情况，比如2,6,4 → 2,2,4
     * 3. 返回计数器是否小于等于1
     **/

    public boolean checkPossibility(int[] nums) {
        if (nums.length <= 2) {
            return true;
        }
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len - 2; i++) {
            if (count > 1) {
                return false;
            }
            // 如果是非降序，直接continue
            if (nums[i] <= nums[i + 1] && nums[i + 1] <= nums[i + 2]) {
                continue;
            }
            // 如果是严格降序，直接返回false
            if (nums[i] > nums[i + 1] && nums[i + 1] > nums[i + 2]) {
                return false;
            }
            // 如果先升后降
            if (nums[i] <= nums[i + 1] && nums[i + 1] > nums[i + 2]) {
                if (nums[i] <= nums[i + 2]) {
                    nums[i + 1] = nums[i];
                } else {
                    nums[i + 2] = nums[i + 1];
                }
                count++;
                continue;
            }
            // 如果先降后升
            if (nums[i] > nums[i + 1] && nums[i + 1] <= nums[i + 2]) {
                if (nums[i] <= nums[i + 2]) {
                    nums[i + 1] = nums[i];
                } else {
                    nums[i] = nums[i + 1];
                }
                count++;
                continue;
            }
        }
        return count <= 1;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                //
                {new int[]{4, 2, 3}, true},
                {new int[]{2, 2, 3, 2}, true},
                {new int[]{4, 2, 1}, false},
                {new int[]{4}, true},
                {new int[]{2, 3, 3, 3, 1}, true},
                {new int[]{3, 4, 2, 3}, false},
                {new int[]{3, 4, 5, 6}, true},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] nums, boolean res) throws Exception {
        boolean result = checkPossibility(nums);
        Assert.assertEquals(result, res);
    }

}
