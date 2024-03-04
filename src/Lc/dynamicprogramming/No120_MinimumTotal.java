package Lc.dynamicprogramming;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/triangle/description/">三角形的最小路径和</a>
 **/
public class No120_MinimumTotal {

    HashMap<String, Integer> memo;

    // f(x, i) = Math.min(f(x+1, i), f(x+1, i+1)) + tra[i]
    public int minimumTotalWithDp(List<List<Integer>> triangle) {
        memo = new HashMap<>();
        return dp(triangle, 0, 0);
    }

    public int dp(List<List<Integer>> triangle, int line, int index) {
        if (line == triangle.size() - 1) {
            // 到达底部，直接返回即可
            return triangle.get(line).get(index);
        }
        String key = line + "_" + index;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int left = dp(triangle, line + 1, index);
        int right = dp(triangle, line + 1, index + 1);
        int res = Math.min(left, right) + triangle.get(line).get(index);
        memo.put(key, res);
        return res;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int res = Integer.MAX_VALUE;
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[] memo = new int[n];
        int[] memoLast = new int[n];
        memo[0] = triangle.get(0).get(0);
        memoLast[0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            int upLeft = Integer.MAX_VALUE, upRight = Integer.MAX_VALUE;
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int number = triangle.get(i).get(j);
                upLeft = j - 1 >= 0 ? memoLast[j - 1] : upLeft;
                upRight = j >= i ? upRight : memoLast[j];
                // TO_YAMENG: 2024/3/4 这个赋值影响了后续的计算
                memo[j] = Math.min(upLeft, upRight) + number;
                if (i == m - 1) {
                    res = Math.min(res, memo[j]);
                }
            }
            memoLast = memo.clone();
            String[] x = Arrays.stream(memoLast).mapToObj(String::valueOf).toArray(String[]::new);
            System.out.println(StringUtils.join(x, ","));
        }
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        ArrayList<Integer> item = new ArrayList<>(Arrays.asList(2));
        ArrayList<Integer> item2 = new ArrayList<>(Arrays.asList(3, 4));
        ArrayList<Integer> item3 = new ArrayList<>(Arrays.asList(6, 5, 7));
        ArrayList<Integer> item4 = new ArrayList<>(Arrays.asList(4, 1, 8, 3));

        List<List<Integer>> tri = new ArrayList<>();
        tri.add(item);
        tri.add(item2);
        tri.add(item3);
        tri.add(item4);

        System.out.println(minimumTotal(tri));


    }
}

