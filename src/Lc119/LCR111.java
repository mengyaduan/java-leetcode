package Lc119;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.*;

public class LCR111 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        // 构建图
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];
            graph.putIfAbsent(a, new HashMap<>());
            graph.get(a).put(b, value);
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(b).put(a, 1 / value);
        }
        for (int i = 0; i < queries.size(); i++) {
            result[i] = compute(graph, queries.get(i).get(0), queries.get(i).get(1));
        }
        return result;
    }

    private double compute(HashMap<String, HashMap<String, Double>> graph, String a, String z) {
        // 如果任一节点图中不存在，返回-1
        if (!graph.containsKey(a) || !graph.containsKey(z)) {
            return -1.0;
        }
        // 如果节点一致，返回1
        if (a.equals(z)) {
            return 1;
        }
        HashSet<String> visited = new HashSet<>();
        Deque<Double> path = new ArrayDeque<>();
        Deque<String> toBeVisited = new ArrayDeque<>();
        toBeVisited.addLast(a);
        path.add(1.0);
        visited.add(a);
        while (!toBeVisited.isEmpty()) {
            String item = toBeVisited.pollFirst();
            double factor = path.pollFirst();
            // 遍历item的邻接点，如果是目标，直接break；如果不是目标且没访问过，则放入到queue中
            for (String nei : graph.get(item).keySet()) {
                if (nei.equals(z)) {
                    return factor * graph.get(item).get(nei);
                }
                if (!visited.contains(nei)) {
                    toBeVisited.addLast(nei);
                    path.addLast(factor * graph.get(item).get(nei));
                    visited.add(nei);
                }
            }
        }
        return -1.0;
    }

    @Test(description = "")
    public void test() throws Exception {
        List<List<String>> equations = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList("a", "b")),
                new ArrayList<>(Arrays.asList("b", "c"))
        ));
        double[] values = new double[]{2.0, 3.0};

        List<List<String>> list = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList("a", "c")),
                new ArrayList<>(Arrays.asList("b", "a")),
                new ArrayList<>(Arrays.asList("a", "e")),
                new ArrayList<>(Arrays.asList("a", "a")),
                new ArrayList<>(Arrays.asList("x", "x"))
        ));

        double[] x = calcEquation(equations, values, list);
        System.out.println(StringUtils.join(Arrays.stream(x).mapToObj(String::valueOf).toArray(), ","));
    }

}
