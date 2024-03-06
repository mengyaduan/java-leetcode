package Lc.dynamicprogramming;

import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.cn/problems/count-all-possible-routes/description/">统计所有可行路径</a>
 **/
public class No1575_CountRoutes {
    HashMap<String, Integer> memo;
    int upLimit = 1000000007;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        memo = new HashMap<>();
        return dp(locations, start, finish, fuel);
    }

    public int dp(int[] locations, int start, int finish, int fuel) {
        if (fuel < 0) {
            return 0;
        }
        String key = start + "_" + finish + "-" + fuel;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        // 如果当前起终点都在终点了，说明一条路径已经形成，此时结果+1
        int x = start == finish ? 1 : 0;
        // 对于从a到b的场景，遍历a到所有其他城市的结果
//        String round = String.format("本轮计算：f(%d, %d, %d) = ", start, finish, fuel);
        for (int i = 0; i < locations.length; i++) {
            if (i == start) {
                continue;
            }
            int rest = fuel - Math.abs(locations[start] - locations[i]);
            int m = dp(locations, i, finish, rest);
            x = (x + m) % upLimit;
//            round = round + String.format("\n\t + f(%d, %d, %d)", i, finish, rest) + " = " + m;
        }
//        System.out.println(round + "\n 最终结果=" + x);
        memo.put(key, x);
        return x;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] loc = new int[]{1, 2, 3};
        System.out.println(countRoutes(loc, 0, 2, 40));
    }

}

