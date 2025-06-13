package Lc119;

import org.testng.annotations.Test;

import java.util.*;

public class LCR109 {
    public int openLock(String[] deadends, String target) {
        HashSet<String> de = new HashSet<>();
        de.addAll(Arrays.asList(deadends));
        String startStr = "0000";
        if (de.contains(startStr) || de.contains(target)) {
            return -1;
        }
        if (target.equals(startStr)) {
            return 0;
        }
        // 取出target节点，找"0000"，记录轮次
        int result = -1;
        HashSet<String> visited = new HashSet<>();
        Deque<String> helper = new ArrayDeque<>();
        helper.addLast(target);
        visited.add(target);
        while (!helper.isEmpty()) {
            result += 1;
            // 遍历当前所有节点，如果有"0000"，则直接返回
            int size = helper.size();
            for (int i = 0; i < size; i++) {
                String item = helper.pollFirst();
                if (startStr.equals(item)) {
                    return result;
                }
                // 将当前节点的所有邻接点，去除已经访问过的，放入到待访问队列，并标记为已访问
                ArrayList<String> neighbors = getNeighbours(item, de);
                neighbors.forEach(x -> {
                    if (!visited.contains(x)) {
                        helper.addLast(x);
                        visited.add(x);
                    }
                });
            }
        }
        return -1;
    }

    private ArrayList<String> getNeighbours(String startStr, HashSet<String> dead) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < startStr.length(); i++) {
            char[] sc = startStr.toCharArray();
            int item = sc[i] - '0';
            int cAdd = (item + 1) % 10;
            int cMinus = (item + 9) % 10;
            sc[i] = (char) ('0' + cAdd);
            String a = new String(sc);
            if (!dead.contains(a)) {
                result.add(a);
            }
            sc[i] = (char) ('0' + cMinus);
            String b = new String(sc);
            if (!dead.contains(b)) {
                result.add(b);
            }
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        int x = openLock(new String[]{}, "0009");
        System.out.println(x);
        x = openLock(new String[]{"0009"}, "0008");
        System.out.println(x);

    }
}
