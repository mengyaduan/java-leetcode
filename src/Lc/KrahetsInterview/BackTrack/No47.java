package Lc.KrahetsInterview.BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/permutations-ii/description/">全排列II</a>
 **/
public class No47 {
    List<List<Integer>> res;
    HashSet<ArrayList<Integer>> helper;

    int[] used;

    private void backtrack(int[] nums, ArrayList<Integer> path) {
        if (path.size() == nums.length) {
            ArrayList<Integer> temp = new ArrayList<>(path);
            if (helper.add(temp)) {
                res.add(temp);
            }
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

    public List<List<Integer>> permuteUnique(int[] nums) {
        helper = new HashSet<>();
        used = new int[nums.length];
        Arrays.fill(used, 0);

        res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        backtrack(nums, path);

        return res;
    }

}

