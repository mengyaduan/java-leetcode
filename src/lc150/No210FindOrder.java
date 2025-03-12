package lc150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class No210FindOrder {


    HashMap<Integer, vertex> needPre;
    HashSet<Integer> visited;
    ArrayList<Integer> order;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        order = new ArrayList<>();
        needPre = new HashMap<>();
        visited = new HashSet<>();
        // 初始化图
        initGraph(prerequisites);
        // 先把所有没依赖的，全都上了
        for (int i = 0; i < numCourses; i++) {
            if (!needPre.containsKey(i)) {
                order.add(i);
            }
        }
        // 针对所有有依赖的，一个一个看
        for (int i = 0; i < numCourses; i++) {
            if (order.contains(i)) {
                // 已经学过的，跳过
                continue;
            }
            boolean res = bfs(i);
            if (!res) {
                return new int[0];
            }
            if (!order.contains(i)) {
                order.add(i);
            }
        }
        int[] result = new int[numCourses];
        for (int i = 0; i < result.length; i++) {
            result[i] = order.get(i);
        }
        return result;
    }

    private boolean bfs(int i) {
        if (visited.contains(i)) {
            //走到还在判断过程中的数据了，循环依赖，返回false
            return false;
        }
        if (order.contains(i)) {
            // 如果已经学过了，则直接返回true
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
        if (res && !order.contains(i)) {
            order.add(i);
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
