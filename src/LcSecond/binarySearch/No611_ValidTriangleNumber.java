package LcSecond.binarySearch;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/valid-triangle-number/description/">有效三角形的个数</a>
 **/
public class No611_ValidTriangleNumber {
    /**
     * 二分搜索法
     **/
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            // fix首位后，然后对后面的参数进行计算
            for (int j = i + 1; j < nums.length - 1; j++) {
                int twoSidesSum = nums[i] + nums[j];
                int twoSidesDiff = Math.abs(nums[i] - nums[j]);
                // 目标数字必须小于sum 且 大于 diff
                int l = j + 1;
                int r = nums.length - 1;
                int right = -1;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (nums[mid] >= twoSidesSum) {
                        r = mid - 1;
                    } else {
                        if (nums[mid] >= twoSidesDiff) {
                            // 往右侧找一找
                            right = mid;
                        }
                        l = mid + 1;
                    }
                }
                if (right == -1) {
                    continue;
                }
                l = j + 1;
                r = nums.length - 1;
                int left = -1;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (nums[mid] >= twoSidesSum) {
                        r = mid - 1;
                    } else {
                        if (nums[mid] >= twoSidesDiff) {
                            // 往左侧找一找
                            left = mid;
                            r = mid - 1;
                        } else {
                            l = mid + 1;
                        }
                    }
                }
                if (left == -1) {
                    continue;
                }
                count += right - left + 1;
            }
        }
        return count;
    }

    /**
     * 可能双指针遍历会更快
     **/

    @Test(description = "")
    public void test() throws Exception {
        int[] numbers = new int[]{1, 1, 3, 4};
        System.out.println(triangleNumber(numbers));

        numbers = new int[]{4, 2, 3, 4};
        System.out.println(triangleNumber(numbers));

        numbers = new int[]{2, 2, 3, 4};
        System.out.println(triangleNumber(numbers));

    }

}
