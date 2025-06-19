package Lc119;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.*;

public class LCR113 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 先构建一张图，同时记录入度表
        int[] degrees = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int[] pre : prerequisites) {
            int from = pre[1];
            int to = pre[0];
            graph.putIfAbsent(from, new ArrayList<>());
            // 由于题目明确不会重复，所以不用担心加重
            graph.get(from).add(to);
            // 更新入度
            degrees[to] += 1;
        }
        // 遍历degrees，找到入度为0的，加入到待处理队列
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> helper = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                helper.addLast(i);
            }
        }
        while (!helper.isEmpty()) {
            int item = helper.pollFirst();
            result.add(item);
            // 将item所有的下游的入度减一，如果减成0了，推进helper
            for (int nei : graph.getOrDefault(item, new ArrayList<>())) {
                degrees[nei] -= 1;
                if (degrees[nei] == 0) {
                    helper.addLast(nei);
                }
            }
        }
        return result.size() == numCourses ? result.stream().mapToInt(Integer::intValue).toArray() : new int[0];
    }

    @Test(description = "")
    public void test() throws Exception {
        int[][] a = new int[][]{
                {1, 0}, {2, 0}, {3, 1}, {3, 2}
        };
        int[] x = findOrder(4, a);
        System.out.println(StringUtils.join(Arrays.stream(x).mapToObj(String::valueOf).toArray(), ","));

    }
}
