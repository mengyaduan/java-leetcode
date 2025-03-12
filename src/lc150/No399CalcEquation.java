package lc150;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.*;

public class No399CalcEquation {

    HashMap<String, Node> nodes;
    HashSet<Node> visited;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        nodes = new HashMap<>();
        visited = new HashSet<>();
        // 初始化图
        initGraph(equations, values);
        // 遍历queries，进行计算
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String start = query.get(0);
            String end = query.get(1);
            if (!nodes.containsKey(start) || !nodes.containsKey(end)) {
                // 如果任意一个不存在，则直接-1
                result[i] = -1.0;
            } else if (start.equals(end)) {
                // 如果一致，则直接1
                result[i] = 1.0;
            } else {
                result[i] = dfs(nodes.get(start), nodes.get(end));
            }
        }
        return result;
    }

    private double dfs(Node startN, Node endN) {
        if (visited.contains(startN)) {
            // 已经处理过了，直接返回，不要再次处理
            return -1.0;
        }
        if (startN.edges.containsKey(endN)) {
            // 存在直通车，直接返回
            return startN.edges.get(endN);
        }
        visited.add(startN);
        // 遍历所有边，需要将处理过的节点加入到visited，不然会死循环
        double res = -1.0;
        for (Node nextNode : startN.edges.keySet()) {
            res = dfs(nextNode, endN);
            if (res != -1.0) {
                res *= startN.edges.get(nextNode);
                break;
            }
        }
        visited.remove(startN);
        return res;
    }

    private void initGraph(List<List<String>> equations, double[] values) {
        for (int i = 0; i < equations.size(); i++) {
            List<String> relation = equations.get(i);
            double weight = values[i];
            String start = relation.get(0);
            String end = relation.get(1);
            Node startN;
            if (nodes.containsKey(start)) {
                startN = nodes.get(start);
            } else {
                startN = new Node(start);
                nodes.put(start, startN);
            }
            Node endN;
            if (nodes.containsKey(end)) {
                endN = nodes.get(end);
            } else {
                endN = new Node(end);
                nodes.put(end, endN);
            }
            startN.edges.put(endN, weight);
            endN.edges.put(startN, 1 / weight);
        }
    }

    class Node {
        // 节点的值
        String name;
        // 由本节点到目标节点的值
        HashMap<Node, Double> edges;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return this.name.equals(node.name);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(name);
        }

        Node(String s) {
            this.name = s;
            this.edges = new HashMap<>();
        }
    }


    @Test(description = "")
    public void test2() throws Exception {
        // 第一部分：List<List<String>> equations
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("x1", "x2"));
        equations.add(Arrays.asList("x2", "x3"));
        equations.add(Arrays.asList("x3", "x4"));
        equations.add(Arrays.asList("x4", "x5"));

        // 第二部分：double[] values
        double[] values = {3.0, 4.0, 5.0, 6.0};

        // 第三部分：List<List<String>> queries
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("x1", "x5"));
        queries.add(Arrays.asList("x5", "x2"));
        queries.add(Arrays.asList("x2", "x4"));
        queries.add(Arrays.asList("x2", "x2"));
        queries.add(Arrays.asList("x2", "x9"));
        queries.add(Arrays.asList("x9", "x9"));

        double[] x = calcEquation(equations, values, queries);
        for (double v : x) {
            System.out.print(v + ", ");
        }


    }

    @Test(description = "")
    public void test() throws Exception {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        equations.add(Arrays.asList("bc", "cd"));

        // 第二部分：double[] values
        double[] values = {1.5, 2.5, 5.0};

        // 第三部分：List<List<String>> queries
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("c", "b"));
        queries.add(Arrays.asList("bc", "cd"));
        queries.add(Arrays.asList("cd", "bc"));


        double[] x = calcEquation(equations, values, queries);
        for (double v : x) {
            System.out.print(v + ", ");
        }

    }


}
