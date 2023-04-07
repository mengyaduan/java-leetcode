package Lc.backtrack;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/subsets/?show=1">no78 子集</a>
 **/
public class No78 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> path = new ArrayList<>();
        backtrack(path, 0, nums);
        return res;
    }

    public void backtrack(ArrayList<Integer> path, int index, int[] n) {
        // 终止条件
        res.add(new ArrayList<>(path));
        for (int i = index; i < n.length; i++) {
            path.add(n[i]);
            backtrack(path, i + 1, n);
            int len = path.size();
            path.remove(len - 1);
        }
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{1, 2, 3}, 2},
                {new int[]{0}, 2},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] n, int k) {
        res.clear();
        List<List<Integer>> x = subsets(n);
        System.out.println(StringUtils.join(x, ","));
        System.out.println();
    }
}
