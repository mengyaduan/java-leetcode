package Lc;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class No46Permute {

    List<List<Integer>> result;
    int[] used;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        used = new int[nums.length];
        backtrack(nums, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, ArrayList<Integer> path) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            backtrack(nums, path);
            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(permute(new int[]{1, 2, 3}));

    }
}
