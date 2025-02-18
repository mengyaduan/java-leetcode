package LcSpring100;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class No365CanMeasureWater {

    /**
     * 还有一个数学思路： 贝祖定理
     * 当target是x和y的最大公约数的倍数时，返回true
     */

    public boolean canMeasureWater(int x, int y, int target) {
        int[] state = new int[]{0, 0};
        Deque<int[]> helper = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();
        helper.add(state);
        visited.add("0_0");
        while (!helper.isEmpty()) {
            // 找到终止条件
            int[] item = helper.pollFirst();
            if (item[0] == target || item[1] == target || item[0] + item[1] == target) {
                return true;
            }
            // 如果没有，则计算所有可能的状态，加入队列（只有set中没有的才加）
            String key = "";
            // 左边倒满
            int[] nextStatus = new int[]{x, item[1]};
            updateQueue(nextStatus, visited, helper);
            // 右边倒满
            nextStatus = new int[]{item[0], y};
            updateQueue(nextStatus, visited, helper);
            // 左边清空
            nextStatus = new int[]{0, item[1]};
            updateQueue(nextStatus, visited, helper);
            // 右边清空
            nextStatus = new int[]{item[0], 0};
            updateQueue(nextStatus, visited, helper);
            // 左边倒进右边
            nextStatus = new int[]{item[0] - Math.min(y - item[1], item[0]), item[1] + Math.min(y - item[1], item[0])};
            updateQueue(nextStatus, visited, helper);
            // 右边倒进左边
            nextStatus = new int[]{item[0] + Math.min(x - item[0], item[1]), item[1] - Math.min(x - item[0], item[1])};
            updateQueue(nextStatus, visited, helper);
        }
        return false;
    }

    private static void updateQueue(int[] nextStatus, HashSet<String> visited, Deque<int[]> helper) {
        String key;
        key = nextStatus[0] + "_" + nextStatus[1];
        if (!visited.contains(key)) {
            visited.add(key);
            helper.addLast(nextStatus);
        }
    }


    @Test(description = "")
    public void test() throws Exception {
        Assert.assertTrue(canMeasureWater(3, 5, 4));
        Assert.assertTrue(canMeasureWater(1, 2, 3));
    }
}
