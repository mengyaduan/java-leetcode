package lc100;

import com.sun.org.apache.xerces.internal.impl.xs.XSElementDecl;
import org.testng.annotations.Test;

import java.util.*;

public class No207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        ArrayList<Integer> order = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] course : prerequisites) {
            inDegrees[course[0]] += 1;
            graph.get(course[1]).add(course[0]);
        }
        Deque<Integer> zeroDegrees = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                zeroDegrees.add(i);
            }
        }
        while (!zeroDegrees.isEmpty()) {
            int item = zeroDegrees.pollFirst();
            order.add(item);
            for (int v : graph.get(item)) {
                inDegrees[v] -= 1;
                if (inDegrees[v] == 0) {
                    zeroDegrees.add(v);
                }
            }
        }
        return order.size() == numCourses;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[][] array = {
                {0, 10},
                {3, 18},
                {5, 5},
                {6, 11},
                {11, 14},
                {13, 1},
                {15, 1},
                {17, 4}
        };
        System.out.println(canFinish(20, array));
        int[][] y = {{1, 0}};
        System.out.println(canFinish(2, y));

    }

    @Test(description = "")
    public void testbad() throws Exception {
        int[][] array = {
                {1, 4},
                {2, 4},
                {3, 1},
                {3, 2}
        };
        System.out.println(canFinish(5, array));


    }
}
