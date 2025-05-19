package Lc119;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LCR080 {

    List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>());
        return result;
    }

    public void backtrack(int n, int k, int idx, ArrayList<Integer> path) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (idx > n) {
            return;
        }
        // 选择当前的数字
        path.add(idx);
        backtrack(n, k, idx + 1, path);
        path.remove(path.size() - 1);
        // 不选择当前的数字
        backtrack(n, k, idx + 1, path);

    }

    @Test(description = "")
    public void test() throws Exception {
        List<List<Integer>> x = combine(4, 2);
        for (List<Integer> item : x) {
            System.out.println(item);
        }
    }


}
