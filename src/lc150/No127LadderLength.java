package lc150;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class No127LadderLength {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        boolean[] visited = new boolean[wordList.size()];
        int result = 0;
        Deque<String> helper = new ArrayDeque<>();
        helper.add(beginWord);
        while (!helper.isEmpty()) {
            int size = helper.size();
            // 每轮变换前，先加1
            result++;
            for (int k = 0; k < size; k++) {
                String item = helper.pollFirst();
                // 遍历bank，将所有未访问的，且距离为1的，都加入到helper中
                for (int i = 0; i < wordList.size(); i++) {
                    if (wordList.get(i) == beginWord) {
                        visited[i] = true;
                    }
                    if (!visited[i] && disOne(item, wordList.get(i))) {
                        if (wordList.get(i).equals(endWord)) {
                            return result + 1;
                        }
                        helper.addLast(wordList.get(i));
                        visited[i] = true;
                    }
                }

            }
        }
        return 0;
    }

    private boolean disOne(String s, String t) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                count++;
            }
        }
        return count == s.length() - 1;
    }

}
