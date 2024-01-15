package Lc.KrahetsInterview.BackTrack;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/permutations/description/">全排列</a>
 **/
public class No46 {

    List<List<Integer>> res;

    int[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new int[nums.length];
        Arrays.fill(used, 0);

        res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        backtrack(nums, path);

        return res;
    }

    private void backtrack(int[] nums, ArrayList<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 0) {
                path.add(nums[i]);
                used[i] = 1;

                backtrack(nums, path);

                path.remove(path.size() - 1);
                used[i] = 0;
            }
        }
    }


    @Test(description = "")
    public void test() throws Exception {
        List<List<Integer>> x = permute(new int[]{1, 2, 3});
        for (List<Integer> item : x) {
            System.out.println(StringUtils.join(item, ","));
        }

    }
}

