package Lc.KrahetsInterview.BackTrack;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @see <a href="https://leetcode.com/problems/combination-sum-ii/description/">组合总和II</a>
 **/
public class No40 {

    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new LinkedList<>();
        Arrays.sort(candidates);
        System.out.println(Arrays.stream(candidates).mapToObj(Integer::toString).collect(Collectors.joining(",")));

        backtrack(candidates, 0, target, new LinkedList<>());

        return res;
    }

    public void backtrack(int[] cand, int startIndex, int target, LinkedList<Integer> path) {
        if (target == 0) {
            res.add(new LinkedList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = startIndex; i < cand.length; i++) {
            if (i > startIndex && cand[i - 1] == cand[i]) {
                continue;
            }
            path.add(cand[i]);

            backtrack(cand, i + 1, target - cand[i], path);

            path.removeLast();
        }
    }


    @Test(description = "")
    public void test() throws Exception {
        List<List<Integer>> x = combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        for (List<Integer> m : x) {
            System.out.println(StringUtils.join(m, ","));
        }

    }

}

