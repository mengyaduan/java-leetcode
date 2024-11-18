package lc100;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class No46 {

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
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            used[i] = 1;
            path.add(nums[i]);
            backtrack(nums, path);
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(permute(new int[]{1, 2, 3}));

    }
}
