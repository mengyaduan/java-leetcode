package Lc.KrahetsInterview.DoublePointers;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @see <a href=https://leetcode.com/problems/3sum/description/"">三数之和</a>
 **/
public class No15SuperComplicated {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<String> helper = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int b = nums[j];
                int need = -(a + b);
                // 在剩下的数据里面找need，有就加到备选集，没有就直接continue
                int hasNeed = findBin(nums, j + 1, nums.length, need);
                if (hasNeed != -1) {
                    if (helper.contains(a + "_" + b) || helper.contains(b + "_" + a) || helper.contains(a + "_" + need) || helper.contains(need + "_" + a)) {
                        // 已经用过了
                        continue;
                    } else {
                        ArrayList<Integer> tmp = new ArrayList<>(Arrays.asList(a, b, need));
                        res.add(tmp);
                        helper.add(a + "_" + b);
                        helper.add(b + "_" + a);
                        helper.add(a + "_" + need);
                        helper.add(need + "_" + a);
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

