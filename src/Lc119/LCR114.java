package Lc119;

import DataStruct.ListNode;
import javafx.scene.control.cell.CheckBoxListCell;
import org.testng.annotations.Test;

import java.util.*;

public class LCR114 {


    public String alienOrder(String[] words) {
        HashMap<Character, ArrayList<Character>> graph = new HashMap<>();
        int[] inDegree = new int[26];
        int letterTotal = 0;
        // 先统计一共有多少个字符
        Arrays.fill(inDegree, -1);
        for (String word : words) {
            for (Character item : word.toCharArray()) {
                if (inDegree[item - 'a'] == -1) {
                    // 只要出现了，就是-1
                    inDegree[item - 'a'] = 0;
                    letterTotal++;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        // 对比相邻单词的第一个不同字符，构建有向图
        String from = words[0];
        for (int i = 1; i < words.length; i++) {
            String to = words[i];
            if (!from.equals(to) && from.startsWith(to)) {
                // 如果出现了错误的排序，直接返回空
                return "";
            }
            updateGraph(from, to, graph, inDegree);
            from = to;
        }
        // 记录入度表
        Deque<Character> helper = new ArrayDeque<>();
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] == 0) {
                helper.addLast((char) (i + 'a'));
            }
        }
        // 从入度=0的开始一个个弹出
        while (!helper.isEmpty()) {
            char item = helper.pollFirst();
            result.append(item);
            // 将关联数据的入度--，如果-到0，入队
            for (Character nei : graph.getOrDefault(item, new ArrayList<>())) {
                inDegree[nei - 'a']--;
                if (inDegree[nei - 'a'] == 0) {
                    helper.addLast(nei);
                }
            }
        }
        // 弹出节点数和letterTotal一致，返回；否则返回空
        return result.length() == letterTotal ? result.toString() : "";
    }

    private void updateGraph(String from, String to, HashMap<Character, ArrayList<Character>> graph, int[] inDegree) {
        // 将from和to分别更新，同时去重
        for (char item : from.toCharArray()) {
            graph.putIfAbsent(item, new ArrayList<>());
        }
        for (char item : to.toCharArray()) {
            graph.putIfAbsent(item, new ArrayList<>());
        }
        // 找到from和to的第一个不同节点to
        for (int i = 0; i < Math.min(from.length(), to.length()); i++) {
            if (from.charAt(i) != to.charAt(i)) {
                // 如果已经添加过关系了，直接break
                if (!graph.get(from.charAt(i)).contains(to.charAt(i))) {
                    graph.get(from.charAt(i)).add(to.charAt(i));
                    inDegree[to.charAt(i) - 'a'] += 1;
                }
                break;
            }
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        String[] words = new String[]{"wrrt", "wrrf", "er", "ett", "rftt", "te"};
        System.out.println(alienOrder(words));
        words = new String[]{"x", "z", "x"};
        System.out.println(alienOrder(words));
        words = new String[]{"x", "z"};
        System.out.println(alienOrder(words));
        words = new String[]{"abc", "ab"};
        System.out.println(alienOrder(words));
        words = new String[]{"x", "x"};
        System.out.println(alienOrder(words));
        words = new String[]{"zy", "zx"};
        System.out.println(alienOrder(words));
    }
}
