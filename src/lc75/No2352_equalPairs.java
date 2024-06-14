package lc75;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @see <a href="https://leetcode.cn/problems/equal-row-and-column-pairs/description/?envType=study-plan-v2&envId=leetcode-75">相等行列对</a>
 */
public class No2352_equalPairs {

    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int res = 0;
        HashMap<String, Integer> row = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j] + "_");
            }
            String key = sb.toString();
            row.put(key, row.getOrDefault(key, 0) + 1);
        }
        for (int j = 0; j < n; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(grid[i][j] + "_");
            }
            String key = sb.toString();
            if (row.containsKey(key)) {
                res += row.get(key);
            }
        }
        return res;
    }

}
