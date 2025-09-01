package LC100Again;


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Lc056 {


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int idx, ArrayList<Integer> path, List<List<Integer>> result) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 不使用当前值
        backtrack(nums, idx + 1, path, result);
        // 使用当前值
        path.add(nums[idx]);
        backtrack(nums, idx + 1, path, result);
        path.remove(path.size() - 1);
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(subsets(new int[]{1, 2}));

    }


}
