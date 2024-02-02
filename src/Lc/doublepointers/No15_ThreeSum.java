package Lc.doublepointers;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/3sum/description/">三数之和</a>
 **/
public class No15_ThreeSum {

    List<List<Integer>> res;

    public List<List<Integer>> threeSum(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        int i = 1, j = nums.length - 1;
        for (int k = 0; k < nums.length - 2; k++) {
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            calculate(nums, k, i, j);
        }
        return res;
    }

    public void calculate(int[] nums, int head, int i, int j) {
        int first = nums[head];
        if (first > 0) {
            return;
        }
        int need = -first;
        while (i < j) {
            int sumNow = nums[i] + nums[j];
            if (sumNow < need) {
                while (i < j && nums[i] == nums[++i]) ;
            } else if (sumNow > need) {
                while (i < j && nums[j] == nums[--j]) ;
            } else {
                res.add(new ArrayList<>(Arrays.asList(nums[head], nums[i], nums[j])));
                while (i < j && nums[i] == nums[++i]) ;
                while (i < j && nums[j] == nums[--j]) ;
            }
        }

    }

    public static boolean findSumOfThree(int[] nums, int target) {
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sumNow = nums[k] + nums[i] + nums[j];
                if (sumNow < target) {
                    while (i < j && nums[i] == nums[++i]) ;
                } else if (sumNow > target) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    return true;
                }
            }
        }
        // Replace this placeholder return statement with your code
        return false;
    }

    @Test(description = "")
    public void tests() throws Exception {
        System.out.println(findSumOfThree(new int[]{1, 0, -1}, 0));

    }
}
