package Lc119;

import java.lang.reflect.Array;
import java.util.*;

public class LCR110 {

    List<List<Integer>> result;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        result = new ArrayList<>();
        int n = graph.length;
        // 构建图
        HashMap<Integer, ArrayList<Integer>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Integer node = i;
            g.put(node, new ArrayList<>());
            for (int item : graph[i]) {
                g.get(node).add(item);
            }
        }
        // 开始找从0到n-1
        ArrayList<Integer> path = new ArrayList<>(Collections.singletonList(0));
        backtrack(g, 0, n - 1, path);
        return result;
    }

    private void backtrack(HashMap<Integer, ArrayList<Integer>> g, int begin, int end, ArrayList<Integer> path) {
        if (begin == end) {
            result.add(new ArrayList<>(path));
            return;
        }
        ArrayList<Integer> neighbors = g.get(begin);
        for (Integer nei : neighbors) {
            path.add(nei);
            backtrack(g, nei, end, path);
            path.remove(path.size() - 1);
        }
    }


}
