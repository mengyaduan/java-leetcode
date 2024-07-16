package lc150;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/3sum/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No15ThreeSum {

    List<List<Integer>> res;

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            findZero(nums, i + 1, nums.length - 1, nums[i]);
        }
        return res;
    }

    private void findZero(int[] nums, int i, int j, int num) {
        while (i < j) {
            int x = nums[i] + nums[j] + num;
            if (x > 0) {
                int tmp = nums[j];
                while (j > i && nums[j] == tmp) {
                    j--;
                }
            } else if (x < 0) {
                int tmp = nums[i];
                while (i < j && nums[i] == tmp) {
                    i++;
                }
            } else {
                res.add(new ArrayList<>(Arrays.asList(num, nums[i], nums[j])));
                int tmp = nums[i];
                while (i < j && nums[i] == tmp) {
                    i++;
                }
                tmp = nums[j];
                while (j > i && nums[j] == tmp) {
                    j--;
                }
            }
        }
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                {new int[]{-1, 0, 1, 2, -1, -4}},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] nums) {
        List<List<Integer>> xx = threeSum(nums);
        System.out.println(xx);

    }
}
