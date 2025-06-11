package Lc119;

import org.testng.IResultMap;
import org.testng.annotations.Test;

import java.util.*;

public class LCR108 {

    int result;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        // 构建一张图，key是节点，value是一个list，用于遍历
        ArrayList<String> nodes = new ArrayList<>();
        nodes.add(beginWord);
        nodes.addAll(wordList);

        HashMap<String, List<String>> graph = new HashMap<>();
        for (String node : nodes) {
            graph.put(node, new ArrayList<>());
        }
        for (String node : nodes) {
            for (String item : wordList) {
                if (distance(node, item) == 1) {
                    graph.get(node).add(item);
                }
            }
        }
        ArrayList<String> from = new ArrayList<>();
        from.add(beginWord);
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        result = 0;
        BFS(endWord, graph, from, visited, 1);
        return result;
    }

    private void BFS(String ew, HashMap<String, List<String>> graph, ArrayList<String> toBeChecked, HashSet<String> visited, int steps) {
        if (toBeChecked.size() == 0) {
            return;
        }
        ArrayList<String> nextRound = new ArrayList<>();
        // 遍历待检查节点，如果有ew则可以返回steps+1
        for (String item : toBeChecked) {
            visited.add(item);
            if (graph.get(item).contains(ew)) {
                result = steps + 1;
                return;
            }
            for (String word : graph.get(item)) {
                if (!visited.contains(word) && !nextRound.contains(word)) {
                    nextRound.add(word);
                }
            }
        }
        BFS(ew, graph, nextRound, visited, steps + 1);
    }

    private int distance(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    @Test(description = "")
    public void test() throws Exception {
        List<String> words = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(ladderLength("hit", "cog", words));

        List<String> words2 = new ArrayList<>(Arrays.asList("hot", "dog"));
        System.out.println(ladderLength("hot", "dog", words2));
    }
}
