package Lc.binarysearch;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/single-element-in-a-sorted-array/">504:有序数组中找单一元素</a>
 **/
public class No540 {

    /**
     * 解题思路：
     * 1. 双指针方法：直接双指针，每次加2，直到左右不一致。但是注意！此时会有++后溢出的场景（这个方法不符合O(log n)的限制，之所以能通过，看起来是leetcode问题）
     * 2. 二分法：
     * - 找到中间值，如果中间值和左右都不一样，则中间值为单一元素，直接return
     * - 中间值是一对数字的左值，则在单侧奇数情况下，目标元素在中间值的左侧；如果单侧偶数，则目标元素在中间值的右侧
     * - 中间值是一对数字的右值，则在单侧奇数情况下，目标元素在中间值的右侧；如果单侧偶数，则目标元素在中间值的左侧
     * - 这里注意，收缩窗口的时候需要将与中间值相同的数字跳过
     **/

    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];

        }
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                return nums[left];
            }
            left += 2;
            right += 2;
        }
        return nums[left];
    }

    public int singleNonDuplicateBinary(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            boolean isOdd = (mid - left) % 2 == 1;
            // 如果中间值是一对数字的左值
            if (nums[mid] == nums[mid + 1]) {
                if (isOdd) {
                    // 1,1,2,2,3,4,4,5,5,6,6
                    right = mid - 1;
                } else {
                    // 1,1,2,2,3
                    left = mid + 2;
                }
            } else {
                // 如果中间值是一对数字的右值
                if (isOdd) {
                    // 1,1,2,2,3,3,4,4,5,6,6
                    left = mid + 1;
                } else {
                    // 1,1,2,3,3,4,4,5,5
                    right = mid - 2;
                }
            }
        }
        return nums[left];
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}, 2},
                {new int[]{3, 3, 7, 7, 10, 11, 11}, 10},
                {new int[]{3, 3, 7}, 7},
                {new int[]{3, 7, 7}, 3},
                {new int[]{3}, 3},

        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] nums, int expected) {
//        int res = singleNonDuplicate(nums);
        int res = singleNonDuplicateBinary(nums);
        Assert.assertEquals(res, expected);
    }
}
