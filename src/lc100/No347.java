package lc100;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static DataStruct.tools.printIntArray;

public class No347 {

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> helper = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int[] item = new int[]{entry.getKey(), entry.getValue()};
            helper.offer(item);
            if (helper.size() > k) {
                helper.poll();
            }
        }
        int[] result = new int[helper.size()];
        int idx = 0;
        while (!helper.isEmpty()) {
            result[idx] = helper.poll()[0];
            idx++;
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        printIntArray(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }
}
