package LC100Again;


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Lc055 {


    List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        int[] used = new int[nums.length];
        backtrack(nums, new ArrayList<>(), used);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> path, int[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            used[i] = 1;
            path.add(nums[i]);
            backtrack(nums, path, used);
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        List<List<Integer>> x = permute(new int[]{1, 2, 3});
        System.out.println(x);
    }


}
