package LC100Again;


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Lc058 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int idx, int left, ArrayList<Integer> path, List<List<Integer>> result) {
        if (left == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            int item = candidates[i];
            if (item > left) {
                continue;
            }
            path.add(item);
            backtrack(candidates, i, left - item, path, result);
            path.remove(path.size() - 1);
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(combinationSum(new int[]{2, 3, 5}, 8));

    }


}
