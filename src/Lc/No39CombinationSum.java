package Lc;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class No39CombinationSum {

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] candidates, int idx, int target, ArrayList<Integer> path) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i], path);
            path.remove(path.size() - 1);
        }
    }


    @Test(description = "")
    public void test() throws Exception {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(combinationSum(new int[]{2, 3, 5}, 8));

    }
}
