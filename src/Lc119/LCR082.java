package Lc119;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCR082 {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] candidates, int left, int idx, List<Integer> path) {
        if (left == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (idx >= candidates.length || left < 0) {
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            int item = candidates[i];
            if (i > idx && item == candidates[i - 1] || item > left) {
                continue;
            }
            path.add(item);
            backtrack(candidates, left - item, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        List<List<Integer>> x = combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        for (List<Integer> item : x) {
            System.out.println(item);
        }

    }
}
