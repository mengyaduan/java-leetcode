package lc100;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class No78 {


    List<List<Integer>> result;
    int[] used;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        used = new int[nums.length];
        backtrack(nums, 0, new ArrayList<>());

        return result;
    }

    private void backtrack(int[] nums, int start, ArrayList<Integer> path) {
        result.add(new ArrayList<>(path));
        if (start >= nums.length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            used[i] = 1;
            path.add(nums[i]);
            backtrack(nums, i + 1, path);
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(subsets(new int[]{1, 2, 3}));

    }
}
