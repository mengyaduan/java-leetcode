package lc100;

import java.util.HashSet;

public class No128 {

    HashSet<Integer> used;

    public int longestConsecutive(int[] nums) {
        used = new HashSet<>();
        HashSet<Integer> helper = new HashSet<>();
        for (int num : nums) {
            helper.add(num);
        }
        int result = 0;
        for (int num : nums) {
            if (used.contains(num)) {
                continue;
            }
            int item = expand(helper, num);
            result = Math.max(result, item);
        }
        return result;
    }

    private int expand(HashSet<Integer> helper, int num) {
        int result = 1;
        int i = num + 1;
        int j = num - 1;
        while (helper.contains(i)) {
            result++;
            used.add(i);
            i++;
        }
        while (helper.contains(j)) {
            result++;
            used.add(j);
            j--;
        }
        return result;
    }

}
