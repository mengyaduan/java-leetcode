package LcSpring100;

import java.util.*;

public class No403CanCross {

    public boolean canCross(int[] stones) {
        if (stones[0] != 0 || stones[1] != 1) {
            return false;
        }
        HashMap<Integer, ArrayList<Integer>> helper = new HashMap<>();
        // 能到1的，只有0
        helper.put(1, new ArrayList<>(Collections.singletonList(0)));
        int target = stones[stones.length - 1];
        for (int i = 1; i < stones.length - 1; i++) {
            // 当前格子不一定能够到达，需要处理
            // 针对每个格子，更新其可以到达的所有点位，从第一个各自开始
            updateCurrentLocation(helper, stones[i]);
            if (helper.containsKey(target)) {
                // 如果已经抵达最后一个，可以提前退出
                return true;
            }
        }
        return false;

    }

    /**
     * 当前站在stone，能够继续往后走的距离
     *
     * @param helper
     * @param stone
     */
    private void updateCurrentLocation(HashMap<Integer, ArrayList<Integer>> helper, int stone) {
        if (!helper.containsKey(stone)) {
            // 当前位置不可达 不需要更新
            return;
        }
        // 记录当前位置可以到达的所有格子，更新helper
        HashSet<Integer> canReach = new HashSet<>();
        ArrayList<Integer> from = helper.get(stone);
        for (int f : from) {
            int k = stone - f;
            canReach.add(stone + k - 1);
            canReach.add(stone + k);
            canReach.add(stone + k + 1);
        }
        // 需要去掉到达自身的情况
        canReach.remove(stone);
        for (int value : canReach) {
            if (helper.containsKey(value)) {
                helper.get(value).add(stone);
            } else {
                helper.put(value, new ArrayList<>(Collections.singletonList(stone)));
            }
        }
    }

}
