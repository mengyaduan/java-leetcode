package lc150;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/permutations/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No46Permute {

    List<List<Integer>> res;
    int[] used;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        used = new int[nums.length];
        backtrack(nums, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, ArrayList<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            backtrack(nums, path);
            path.remove(path.size() - 1);
            used[i] = 0;
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
