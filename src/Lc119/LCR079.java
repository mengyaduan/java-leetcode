package Lc119;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LCR079 {

    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] nums, int idx, ArrayList<Integer> path) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        int item = nums[idx];
        // 选择当前
        path.add(item);
        backtrack(nums, idx + 1, path);
        path.remove(path.size() - 1);
        // 不选择当前
        backtrack(nums, idx + 1, path);
    }

    @Test(description = "")
    public void test() throws Exception {
        List<List<Integer>> x = subsets(new int[]{1, 2, 3});
        for (List<Integer> item : x) {
            System.out.println(item);
        }
    }
}
