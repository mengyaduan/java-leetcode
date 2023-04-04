package Lc.backtrack;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/combinations/?show=1">no77 组合</a>
 **/
public class No77 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        ArrayList<Integer> path = new ArrayList<>();
        backtrack(path, 1, n, k);

        return res;
    }

    public void backtrack(ArrayList<Integer> path, int index, int n, int k) {
        // 终止条件
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
        }
        for (int i = index; i <= n; i++) {
            path.add(i);
            backtrack(path, i + 1, n, k);
            int len = path.size();
            path.remove(len - 1);
        }
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {4, 2},
                {1, 1},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int n, int k) {
        res.clear();
        List<List<Integer>> x = combine(n, k);
        System.out.println(StringUtils.join(x, ","));
        System.out.println();
    }
}
