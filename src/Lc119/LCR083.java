package Lc119;

import org.apache.commons.lang3.EnumUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LCR083 {

    List<List<Integer>> result;
    int[] memo;

    public List<List<Integer>> permute(int[] nums) {
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
            memo[i] = 1;
            path.add(nums[i]);
            backtrack(nums, path);
            path.remove(path.size() - 1);
            memo[i] = 0;
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        List<List<Integer>> x = permute(new int[]{1, 2, 3});
        for (List<Integer> item : x) {
            System.out.println(item);
        }

    }
}
