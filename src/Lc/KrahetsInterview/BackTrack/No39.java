package Lc.KrahetsInterview.BackTrack;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/combination-sum/description/">组合总和</a>
 **/
public class No39 {

    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();

        backtrack(candidates, 0, target, new ArrayList<>());

        return res;
    }

    public void backtrack(int[] cand, int startIndex, int target, ArrayList<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = startIndex; i < cand.length; i++) {
            path.add(cand[i]);
            backtrack(cand, i, target - cand[i], path);
            path.remove(path.size() - 1);
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        List<List<Integer>> x = combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> m : x) {
            System.out.println(StringUtils.join(m, ","));
        }

    }

}

