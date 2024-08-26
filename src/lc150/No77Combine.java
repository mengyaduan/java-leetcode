package lc150;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class No77Combine {

    List<List<Integer>> res;
    int[] used;


    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        used = new int[n + 1];
        backtrack(1, n, k, new ArrayList<>());
        return res;
    }

    private void backtrack(int start, int n, int k, ArrayList<Integer> path) {
        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            if (used[i] == 1) {
                continue;
            }
            path.add(i);
            used[i] = 1;
            backtrack(i + 1, n, k - 1, path);
            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        List<List<Integer>> x = combine(3, 3);
        for (List<Integer> item : x) {
            System.out.println(item);
        }

    }
}
