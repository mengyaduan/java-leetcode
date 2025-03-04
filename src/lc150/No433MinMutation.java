package lc150;

import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class No433MinMutation {

    public int minMutation(String startGene, String endGene, String[] bank) {
        boolean[] visited = new boolean[bank.length];
        int result = 0;
        // 如果开始就符合，直接返回
        if (startGene.equals(endGene)) {
            return result;
        }
        Deque<String> helper = new ArrayDeque<>();
        helper.add(startGene);
        while (!helper.isEmpty()) {
            int size = helper.size();
            // 每轮变换前，先加1
            result++;
            for (int k = 0; k < size; k++) {
                String item = helper.pollFirst();
                // 遍历bank，将所有未访问的，且距离为1的，都加入到helper中
                for (int i = 0; i < bank.length; i++) {
                    if (bank[i] == startGene) {
                        visited[i] = true;
                    }
                    if (!visited[i] && disOne(item, bank[i])) {
                        if (bank[i].equals(endGene)) {
                            return result;
                        }
                        helper.addLast(bank[i]);
                        visited[i] = true;
                    }
                }

            }
        }
        return -1;
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

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(minMutation("AAAAAAAA", "CCCCCCCC",
                new String[]{"AAAAAAAA", "AAAAAAAC", "AAAAAACC", "AAAAACCC", "AAAACCCC", "AACACCCC", "ACCACCCC", "ACCCCCCC", "CCCCCCCA", "CCCCCCCC"}));

    }
}
