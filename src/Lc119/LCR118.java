package Lc119;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.*;

public class LCR118 {

    public int[] findRedundantConnection(int[][] edges) {
        int[] result = new int[2];
        // 构建一张图
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.putIfAbsent(a, new HashSet<>());
            graph.get(a).add(b);
            graph.putIfAbsent(b, new HashSet<>());
            graph.get(b).add(a);
        }
        // 记录每个node的邻接点数量
        Deque<Integer> helper = new ArrayDeque<>();
        int[] nodes = new int[graph.keySet().size()];
        for (int node : graph.keySet()) {
            nodes[node - 1] = graph.get(node).size();
            if (nodes[node - 1] == 1) {
                // 如果只有一个邻接点，直接入队，记录为0
                helper.addLast(node);
            }
        }
        // 从叶节点的开始删除，直到没有任何可以更新的节点，剩下的就一定在环里
        while (!helper.isEmpty()) {
            int item = helper.pollFirst();
            nodes[item - 1] -= 1;
            // 弹出该节点：1.将关联关系删除；2.更新邻接点数量
            for (int nei : graph.get(item)) {
                graph.get(nei).remove(item);
                nodes[nei - 1] -= 1;
                if (nodes[nei - 1] == 1) {
                    // 如果更新后变成叶节点，入队
                    helper.addLast(nei);
                }
            }
        }
        HashSet<Integer> circle = new HashSet<>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != 0) {
                circle.add(i + 1);
            }
        }
        // 倒序遍历edges，如果两个节点同时出现在环里，则返回
        for (int i = edges.length - 1; i >= 0; i--) {
            int[] item = edges[i];
            if (circle.contains(item[0]) && circle.contains(item[1])){
                return item;
            }
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[][] edges = {
                {9, 10},
                {5, 8},
                {2, 6},
                {1, 5},
                {3, 8},
                {4, 9},
                {8, 10},
                {4, 10},
                {6, 8},
                {7, 9}
        };
        int[] x = findRedundantConnection(edges);
        System.out.println(StringUtils.join(Arrays.stream(x).mapToObj(String::valueOf).toArray(), ","));

    }

}
