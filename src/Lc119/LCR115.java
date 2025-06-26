package Lc119;

import org.testng.annotations.Test;

import java.util.*;

public class LCR115 {

    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        // 根据seq构建graph
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        for (int[] pair : sequences) {
            updateGraph(pair, graph, inDegree);
        }
        Deque<Integer> helper = new ArrayDeque<>();
        for (int item : inDegree.keySet()) {
            if (inDegree.get(item) == 0) {
                helper.addLast(item);
            }
        }
        if (helper.size() != 1) {
            // 只要有超过一个起点，结果一定不唯一！
            return false;
        }
        ArrayList<Integer> topoRes = new ArrayList<>();
        // 拓扑排序，如果非最后一个节点弹出的时候，没有新的节点加入，则可以直接返回false
        while (!helper.isEmpty()) {
            int item = helper.pollFirst();
            topoRes.add(item);
            boolean hasNext = false;
            // 更新item邻接点
            for (int nei : graph.get(item)) {
                inDegree.put(nei, inDegree.get(nei) - 1);
                if (inDegree.get(nei) == 0) {
                    helper.addLast(nei);
                    hasNext = true;
                }
            }
            if (!hasNext && !helper.isEmpty()) {
                return false;
            }
        }
        // 对比拓扑排序后的结果，节点数和nums是不是一样，如果nums.length() > topoRes.length()，返回false
        if (nums.length > topoRes.size()) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != topoRes.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void updateGraph(int[] pair, HashMap<Integer, HashSet<Integer>> graph, HashMap<Integer, Integer> inDegree) {
        for (int i = 0; i < pair.length; i++) {
            int cur = pair[i];
            // 将节点加入图
            graph.putIfAbsent(cur, new HashSet<>());
            inDegree.putIfAbsent(cur, 0);
            if (i == 0) {
                continue;
            }
            // 如果前置节点没有加过当前节点，则追加，同时更新入度map
            int pre = pair[i - 1];
            if (!graph.get(pre).contains(cur)) {
                graph.get(pre).add(cur);
                inDegree.put(cur, inDegree.get(cur) + 1);
            }
        }

    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(sequenceReconstruction(new int[]{4, 1, 5, 2, 6, 3}, new int[][]{{5, 2, 6, 3}, {4, 1, 5, 2}}));
        System.out.println(sequenceReconstruction(new int[]{1, 2, 3}, new int[][]{{1, 2}, {1, 3}}));
        System.out.println(sequenceReconstruction(new int[]{1, 2, 3}, new int[][]{{1, 2}, {1, 3}, {2, 3}}));
        System.out.println(sequenceReconstruction(new int[]{1, 2, 3}, new int[][]{{1, 2}}));
    }
}
