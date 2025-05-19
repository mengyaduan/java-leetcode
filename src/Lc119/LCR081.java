package Lc119;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LCR081 {

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] candidates, int left, int idx, List<Integer> path) {
        if (left == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (left < 0) {
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            int item = candidates[i];
            if (item <= left) {
                path.add(item);
                backtrack(candidates, left - item, i, path);
                path.remove(path.size() - 1);
            }
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        List<List<Integer>> x = combinationSum(new int[]{2, 3, 5}, 8);
        for (List<Integer> item : x) {
            System.out.println(item);
        }

        x = combinationSum(new int[]{2}, 1);
        for (List<Integer> item : x) {
            System.out.println(item);
        }

    }
}
