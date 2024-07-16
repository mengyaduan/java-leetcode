package lc150;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @see <a href="https://leetcode.cn/problems/two-sum/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No2TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[][] helper = new int[nums.length][2];
        for (int i = 0; i < helper.length; i++) {
            helper[i][0] = nums[i];
            helper[i][1] = i;
        }
        Arrays.sort(helper, (a, b) -> a[0] - b[0]);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int item = helper[i][0] + helper[j][0];
            if (item == target) {
                return new int[]{helper[i][1], helper[j][1]};
            } else if (item < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    public int[] twoSumAns(int[] nums, int target) {
        HashMap<Integer, Integer> helper = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (helper.containsKey(need)) {
                return new int[]{helper.get(need), i};
            }
            helper.put(nums[i], i);
        }
        return null;
    }


    @Test(description = "")
    public void test() throws Exception {
        System.out.println(twoSum(new int[]{3, 2, 4}, 6));
        System.out.println(twoSum(new int[]{3, 3}, 6));

    }
}
