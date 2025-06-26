package Lc119;

import org.testng.annotations.Test;

import java.util.*;

public class LCR117 {

    public int numSimilarGroups(String[] strs) {
        int result = 0;
        // 构建一张图
        HashMap<String, HashSet<String>> graph = new HashMap<>();
        HashSet<String> visited = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                addToGraph(strs[i], strs[j], graph);
            }
        }
        // 随便选取一个节点，result++，bfs，标记visited，走完以后如果还有剩余节点，则继续新一轮
        for (int i = 0; i < strs.length; i++) {
            if (visited.contains(strs[i])) {
                continue;
            }
            result++;
            dfs(strs[i], graph, visited);
        }
        return result;
    }

    private void dfs(String s, HashMap<String, HashSet<String>> graph, HashSet<String> visited) {
        // 首先标记已查询过
        visited.add(s);
        // 遍历邻接点
        for (String nei : graph.get(s)) {
            if (!visited.contains(nei)) {
                dfs(nei, graph, visited);
            }
        }
    }

    private void addToGraph(String a, String b, HashMap<String, HashSet<String>> graph) {
        // 如果节点不存在，加入到图中
        graph.putIfAbsent(a, new HashSet<>());
        graph.putIfAbsent(b, new HashSet<>());
        // 如果ab符合要求，则加入边
        if (match(a, b)) {
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }

    private boolean match(String s, String target) {
        if (s.equals(target)) {
            return true;
        }
        if (s.length() != target.length()) {
            return false;
        }
        int cnt = 0, x = -1, y = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != target.charAt(i)) {
                cnt++;
                y = x == -1 ? -1 : (y == -1 ? i : y);
                x = x == -1 ? i : x;
            }
        }
        if (cnt == 2) {
            return s.charAt(x) == target.charAt(y) && s.charAt(y) == target.charAt(x);
        }
        return false;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(numSimilarGroups(new String[]{
                "zkhnmefhyr", "ykznfhehmr", "mkhnyefrzh",
                "zkhnyefrmh", "zkmnhefhyr", "ykznhfehmr",
                "zkynhfehmr", "mkhnhefrzy", "zkhnmefryh", "zkmnhfehyr"}));

        System.out.println(numSimilarGroups(new String[]{
                "kccomwcgcs",
                "socgcmcwkc",
                "sgckwcmcoc",
                "coswcmcgkc",
                "cowkccmsgc",
                "cosgmccwkc",
                "sgmkwcccoc",
                "coswmccgkc",
                "kowcccmsgc",
                "kgcomwcccs"}));

        System.out.println(numSimilarGroups(new String[]{"tars", "rats", "arts", "star"}));
        System.out.println(numSimilarGroups(new String[]{"omv", "ovm"}));

    }
}
