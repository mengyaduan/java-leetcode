package Lc.KrahetsInterview.DoublePointers;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href=https://leetcode.com/problems/3sum/description/"">三数之和</a>
 **/
public class No15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum > 0) {
                    // j--
                    int rightNow = nums[j];
                    while (i < j && nums[j] == rightNow) {
                        j--;
                    }
                } else if (sum < 0) {
                    // 需要一个更大的整数，此时i前进到下一个新数字
                    int leftNow = nums[i];
                    while (i < j && nums[i] == leftNow) {
                        i++;
                    }
                } else {
                    // 等于0，加入结果集合，并同时缩小左右index
                    res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    int leftNow = nums[i];
                    while (i < j && nums[i] == leftNow) {
                        i++;
                    }
                    int rightNow = nums[j];
                    while (i < j && nums[j] == rightNow) {
                        j--;
                    }
                }

            }
        }
        return res;
    }

    private int findBin(int[] nums, int left, int right, int target) {
        if (target > nums[right - 1] || target < nums[left]) {
            return -1;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                //
                {new int[]{-1, 0, 1, 2, -1, -4}},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] nums) {
        List<List<Integer>> xx = threeSum(nums);
        System.out.println(xx);

    }

}

