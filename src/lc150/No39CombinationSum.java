package lc150;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/combination-sum/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No39CombinationSum {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>());

        return res;
    }

    private void backtrack(int start, int[] candidates, int target, ArrayList<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 因为都是正数，可以跳过
            if (target - candidates[i] < 0) {
                continue;
            }
            path.add(candidates[i]);
            backtrack(i, candidates, target - candidates[i], path);
            path.remove(path.size() - 1);
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        List<List<Integer>> x = combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> item : x) {
            System.out.println(item);
        }


    }


}
