package Lc119;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCR084 {

    List<List<Integer>> result;
    int[] memo;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        result = new ArrayList<>();
        memo = new int[nums.length];
        backtrack(nums, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] nums, List<Integer> path) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (memo[i] == 1) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && memo[i - 1] == 0) {
                continue;
            }
            memo[i] = 1;
            path.add(nums[i]);
            backtrack(nums, path);
            path.remove(path.size() - 1);
            memo[i] = 0;
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        List<List<Integer>> x = permuteUnique(new int[]{1, 2, 2});
        for (List<Integer> item : x) {
            System.out.println(item);
        }


    }
}
