package lc150;

import javax.print.attribute.HashPrintServiceAttributeSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class No207CanFinish {


    HashMap<Integer, vertex> needPre;
    HashSet<Integer> visited;
    HashSet<Integer> learnt;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        needPre = new HashMap<>();
        visited = new HashSet<>();
        learnt = new HashSet<>();
        // 初始化图
        initGraph(prerequisites);
        // 遍历课程，没在节点中出现的，可以直接完成
        for (int i = 0; i < numCourses; i++) {
            boolean res = bfs(i);
            if (!res) {
                return false;
            }
            learnt.add(i);
        }
        return true;
    }

    private boolean bfs(int i) {
        if (visited.contains(i)) {
            //走到还在判断过程中的数据了，循环依赖，返回false
            return false;
        }
        if (!needPre.containsKey(i) || learnt.contains(i)) {
            // 如果没有依赖，或者已经学过了，则直接返回true
            return true;
        }
        // 如果有依赖，则需要遍历所有节点，查看是否全都满足
        visited.add(i);
        boolean res = true;
        for (Integer nextCourse : needPre.get(i).edges) {
            res &= bfs(nextCourse);
            if (!res) {
                break;
            }
        }
        if (res) {
            learnt.add(i);
        }
        visited.remove(i);
        return res;
    }

    private void initGraph(int[][] prerequisites) {
        for (int[] relation : prerequisites) {
            int target = relation[0];
            int need = relation[1];
            vertex targetV;
            if (needPre.containsKey(target)) {
                targetV = needPre.get(target);
            } else {
                targetV = new vertex(target);
                needPre.put(target, targetV);
            }
            targetV.edges.add(need);
        }
    }

    class vertex {
        int value;
        ArrayList<Integer> edges;

        vertex(int value) {
            this.value = value;
            edges = new ArrayList<>();
        }
    }

}
