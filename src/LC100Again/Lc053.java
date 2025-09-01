package LC100Again;


import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class Lc053 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int learnt = 0;
        int[] indegree = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> helper = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            // x 依赖y
            int x = prerequisites[i][0];
            int y = prerequisites[i][1];
            indegree[x] += 1;
            helper.putIfAbsent(y, new ArrayList<>());
            helper.get(y).add(x);
        }
        Deque<Integer> zero = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                zero.offerLast(i);
            }
        }
        while (!zero.isEmpty()) {
            // 每次弹出一个没依赖的课，将依赖他的--
            int item = zero.pollFirst();
            learnt++;
            if (helper.containsKey(item)) {
                for (int x : helper.get(item)) {
                    indegree[x] -= 1;
                    if (indegree[x] == 0) {
                        zero.offerLast(x);
                    }
                }
            }
        }
        return learnt == numCourses;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(canFinish(2, new int[][]{{1, 0}}));

    }


}
