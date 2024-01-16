package Lc.KrahetsInterview.BackTrack;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/permutations-ii/description/">全排列II</a>
 **/
public class No47 {
    List<List<Integer>> res;

    int[] used;

    private void backtrack(int[] nums, ArrayList<Integer> path) {
        if (path.size() == nums.length) {
            ArrayList<Integer> temp = new ArrayList<>(path);
            res.add(temp);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 0 && !(i > 0 && nums[i - 1] == nums[i] && used[i - 1] == 1)) {
                path.add(nums[i]);
                used[i] = 1;

                backtrack(nums, path);

                path.remove(path.size() - 1);
                used[i] = 0;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new int[nums.length];
        Arrays.fill(used, 0);
        Arrays.sort(nums);

        res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        backtrack(nums, path);

        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        List<List<Integer>> x = permuteUnique(new int[]{1, 2, 1});
        for (List<Integer> m : x) {
            System.out.println(StringUtils.join(m, ","));
        }

    }
}

