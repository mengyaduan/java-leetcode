package Lc119;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;

public class LCR119 {

    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> visited = new HashMap<>();
        HashSet<Integer> helper = new HashSet<>();
        for (int num : nums) {
            helper.add(num);
        }
        int result = 0;
        for (int item : nums) {
            if (!visited.containsKey(item)) {
                int x = findNext(item + 1, helper, visited, 1);
                visited.put(item, x);
                result = Math.max(result, x);
            }
        }
        return result;
    }

    private int findNext(int item, HashSet<Integer> helper, HashMap<Integer, Integer> visited, int path) {
        if (!helper.contains(item)) {
            return path;
        }
        if (visited.containsKey(item)) {
            // 已经找过了，直接加上结果
            return path + visited.get(item);
        }
        int res = findNext(item + 1, helper, visited, path + 1);
        visited.put(item, res);
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] n = new int[]{9, 1, -3, 2, 4, 8, 3, -1, 6, -2, -4, 7};
        System.out.println(longestConsecutive(n));

    }
}
