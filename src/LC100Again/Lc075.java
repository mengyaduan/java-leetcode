package LC100Again;


import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static DataStruct.tools.printIntArray;

public class Lc075 {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> kv = new HashMap<>();
        for (int item : nums) {
            kv.put(item, kv.getOrDefault(item, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> helper = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : kv.entrySet()) {
            helper.offer(entry);
            if (helper.size() == k + 1) {
                helper.poll();
            }
        }
        int[] result = new int[k];
        int i = k - 1;
        while (!helper.isEmpty()) {
            result[i--] = helper.poll().getKey();
        }
        return result;
    }


    @Test(description = "")
    public void test() throws Exception {
        printIntArray(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));

    }

}
