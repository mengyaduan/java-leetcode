package Lc119;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class LCR116 {


    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        // 建一张图，将所有关联城市连接
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (isConnected[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }
        // 遍历城市节点，bfs，将所有关联的划到一起
        int result = 0;
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 1) {
                continue;
            }
            result++;
            bfs(graph, i, visited);
        }
        return result;
    }

    private void bfs(HashMap<Integer, ArrayList<Integer>> graph, int i, int[] visited) {
        // 将i标记为已访问，然后遍历所有i的邻接点，如果没访问过，继续往后访问
        visited[i] = 1;
        ArrayList<Integer> toVisit = new ArrayList<>();
        for (int nei : graph.get(i)) {
            if (visited[nei] == 0) {
                toVisit.add(nei);
            }
        }
        toVisit.forEach(x -> bfs(graph, x, visited));
    }

    @Test(description = "")
    public void test() throws Exception {
        int[][] isConnected = new int[][]{
                {1, 1, 0}, {1, 1, 0}, {0, 0, 1}
        };
        System.out.println(findCircleNum(isConnected));

    }


}
