package Lc;

import com.sun.crypto.provider.HmacMD5;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class No40CombinationSumII {

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] candidates, int idx, int target, ArrayList<Integer> path) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (target < 0 || idx >= candidates.length) {
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i - 1] == candidates[i]) {
                continue;
            }
            if (target - candidates[i] >= 0) {
                path.add(candidates[i]);
                backtrack(candidates, i + 1, target - candidates[i], path);
                path.remove(path.size() - 1);
            }
        }
    }


    @Test(description = "")
    public void test() throws Exception {
//        System.out.println(combinationSum2(new int[]{1, 1, 2, 5, 6, 7, 10}, 8));
//        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(combinationSum2(new int[]{2, 5, 2, 1, 2, 2}, 7));

    }
}
