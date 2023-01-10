package Lc.backtrack;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/permutations/">No46 数字全排列</a>
 **/
public class No46 {


    List<List<Integer>> res = new ArrayList<>();


    public List<List<Integer>> permute(int[] nums) {
        // 当前路径，选择列表
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(path, nums, used);
        return res;
    }

    public void backtrack(List<Integer> path, int[] nums, boolean[] used) {
        // 终止条件
        if (path.size() == nums.length) {
            List<Integer> ans = new ArrayList<>(path);
            res.add(ans);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 加入路径，并从选择列表中删除
            path.add(nums[i]);
            used[i] = true;
            // 回溯
            backtrack(path, nums, used);
            // 从路径中删除，并加入选择列表
            int last = path.size() - 1;
            path.remove(last);
            used[i] = false;
        }
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{2}, new int[]{}, 2},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] nums1, List<List<Integer>> expected) {
        List<List<Integer>> res = permute(nums1);
        Assert.assertEquals(res, expected);
    }

    @Test(description = "")
    public void test2() throws Exception {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> x = permute(nums);
        for (List<Integer> item : x) {
            for (Integer a : item) {
                System.out.print(a + " ");
            }
            System.out.println();
        }

    }
}
