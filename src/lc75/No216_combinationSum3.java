package lc75;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/combination-sum-iii/description/?envType=study-plan-v2&envId=leetcode-75">组合总和3</a>
 */
public class No216_combinationSum3 {

    int[] used;
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        // 用来记录1到9的使用状态
        used = new int[10];
        backtrack(1, k, n, new ArrayList<>());
        return res;
    }

    private void backtrack(int start, int k, int sum, ArrayList<Integer> path) {
        if (sum == 0) {
            if (path.size() == k) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = start; i < 10; i++) {
            if (used[i] == 1) {
                continue;
            }
            used[i] = 1;
            path.add(i);
            backtrack(i + 1, k, sum - i, path);
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }


    @Test(description = "")
    public void test() throws Exception {
        List<List<Integer>> x = combinationSum3(4, 1);
        for (List item : x) {
            System.out.println(StringUtils.join(item, ","));
        }

    }
}
