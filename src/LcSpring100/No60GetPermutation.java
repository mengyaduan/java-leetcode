package LcSpring100;

import bsh.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class No60GetPermutation {

    int[] used;
    int count;

    public String getPermutation(int n, int k) {
        count = k;
        used = new int[n + 1];
        return backtrack(n, new ArrayList<>());
    }

    private String backtrack(int n, ArrayList<Integer> path) {
        if (path.size() == n) {
            count--;
            if (count == 0) {
                StringBuilder result = new StringBuilder();
                for (Integer x : path) {
                    result.append(x);
                }
                return result.toString();
            }
            return "";
        }

        for (int i = 1; i <= n; i++) {
            if (used[i] == 1) {
                continue;
            }
            used[i] = 1;
            path.add(i);
            String s = backtrack(n, path);
            if (!s.isEmpty()) {
                return s;
            }
            path.remove(path.size() - 1);
            used[i] = 0;
        }
        return "";
    }

    @Test(description = "")
    public void test() throws Exception {

        System.out.println(getPermutation(3, 3));
    }
}