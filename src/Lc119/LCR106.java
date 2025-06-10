package Lc119;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LCR106 {

    public boolean isBipartite(int[][] graph) {
        // 修改图，改成好操作的集合
        HashMap<Integer, HashSet<Integer>> g = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            g.put(i, new HashSet<>());
            for (int j = 0; j < graph[i].length; j++) {
                g.get(i).add(graph[i][j]);
            }
        }
        int[] memo = new int[graph.length];
        int cnt = 0;
        // 创建两个节点集合
        HashSet<Integer> leftSide = new HashSet<>(), rightSide = new HashSet<>();
        // 遍历图，尝试二分，如果失败返回false
        for (int i = 0; i < graph.length; i++) {
            int curNode = i;
            boolean result = process(leftSide, rightSide, g, curNode, memo);
            if (!result) {
                return false;
            }
        }
        return true;
    }

    private boolean process(HashSet<Integer> from, HashSet<Integer> to, HashMap<Integer, HashSet<Integer>> g, int curNode, int[] memo) {
        if (memo[curNode] == 1) {
            // 已经处理过，直接跳过
            return true;
        }
        // 将当前节点加入from
        from.add(curNode);
        // 将当前节点标记为已处理
        memo[curNode] = 1;
        // 将关联节点加入to
        ArrayList<Integer> todo = new ArrayList<>();
        for (int item : g.get(curNode)) {
            if (from.contains(item)) {
                // 如果from里面也有item，肯定错
                return false;
            }
            to.add(item);
            todo.add(item);
        }
        // 将本次加入to的节点，都重新处理一次
        boolean res = true;
        for (int item : todo) {
            res = process(to, from, g, item, memo);
            if (!res) {
                return false;
            }
        }
        return true;
    }

    boolean valid = true;
    int RED = 1, GREEN = 2, UNDEFINED = 0;

    public boolean isBipartite2(int[][] graph) {
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            int colorNeighbor = GREEN;
            if (color[i] != UNDEFINED) {
                colorNeighbor = color[i] == RED ? GREEN : RED;
            } else {
                color[i] = RED;
            }
            paint(graph, color, i, color[i], colorNeighbor);
            if (!valid) {
                return false;
            }
        }
        return true;
    }

    private void paint(int[][] graph, int[] color, int cur, int colorCur, int colorNeighbor) {
        int[] neighbors = graph[cur];
        for (int nei : neighbors) {
            boolean dfsFlag = false;
            if (color[nei] == UNDEFINED) {
                dfsFlag = true;
                color[nei] = colorNeighbor;
            }
            if (color[nei] == colorCur) {
                // 目标已经染色，且和cur是同色
                valid = false;
                return;
            }
            if (dfsFlag) {
                paint(graph, color, nei, colorNeighbor, colorCur);
            }
        }

    }


}
