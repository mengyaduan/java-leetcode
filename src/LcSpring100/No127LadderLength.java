package LcSpring100;

import org.testng.annotations.Test;

import java.sql.Struct;
import java.util.*;

public class No127LadderLength {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 0;
        if (!wordList.contains(endWord)) {
            return result;
        }
        Deque<String> helper = new ArrayDeque<>();
        helper.add(endWord);
        int[] used = new int[wordList.size()];
        // 先计算begin到目标，如果是1，直接返回result+1
        result = 1;
        while (!helper.isEmpty()) {
            int size = helper.size();
            HashSet<String> layer = new HashSet<>();
            for (int i = 0; i < size; i++) {
                // 计算当前轮次
                String item = helper.pollFirst();
                int distance = computeDistance(beginWord, item);
                if (distance == 1) {
                    return result + 1;
                }
                layer.add(item);
            }
            // 对于layer里面的元素，只要能一步转到的，都加到deque中，并标记为已查找
            for (int i = 0; i < wordList.size(); i++) {
                String item = wordList.get(i);
                if (layer.contains(item) || used[i] == 1) {
                    used[i] = 1;
                    continue;
                }
                for (String layerItem : layer) {
                    int x = computeDistance(item, layerItem);
                    if (x == 1) {
                        helper.add(item);
                        break;
                    }
                }
            }
            result++;
        }
        return 0;
    }

    public int computeDistance(String a, String b) {
        int result = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                result++;
            }
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(ladderLength("hit", "cog", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));
        System.out.println(ladderLength("cot", "cog", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));

    }

}
