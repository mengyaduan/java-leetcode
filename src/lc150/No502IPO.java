package lc150;

import jdk.nashorn.internal.codegen.SpillObjectCreator;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class No502IPO {

    /**
     * 最终的目标就是，一共执行K轮，每轮找到当前资本下，净利润最高的项目
     */

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] cp = new int[profits.length][2];
        for (int i = 0; i < profits.length; i++) {
            cp[i][0] = capital[i];
            cp[i][1] = profits[i];
        }
        // 按照成本排序
        Arrays.sort(cp, (a, b) -> a[0] - b[0]);
        // 定义一个大根堆，按照利润维度
        PriorityQueue<int[]> helper = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int result = w;
        int i = 0;
        // 遍历k次
        while (k > 0) {
            // 将成本小于等于result的加入到堆中
            while (i < cp.length && cp[i][0] <= result) {
                helper.add(cp[i]);
                i++;
            }
            if (helper.isEmpty()) {
                // 如果没的可做，就退出
                break;
            }
            int[] item = helper.poll();
            result += item[1];
            k--;
        }
        return result;
    }


    @Test(description = "")
    public void test() throws Exception {
        int[] profits = new int[]{1, 2, 3};
        int[] capital = new int[]{0, 1, 1};
        System.out.println(findMaximizedCapital(3, 3, profits, capital));


    }
}
