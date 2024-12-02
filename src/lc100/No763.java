package lc100;

import org.testng.annotations.Test;

import java.util.*;

public class No763 {

    public List<Integer> partitionLabels(String s) {
        char[] c = s.toCharArray();
        HashMap<Character, int[]> letters = new HashMap<>();
        for (int i = 0; i < c.length; i++) {
            if (letters.containsKey(c[i])) {
                letters.get(c[i])[1] = i;
            } else {
                letters.put(c[i], new int[]{i, i});
            }
        }
        int[][] ranges = new int[letters.size()][2];
        int i = 0;
        for (Map.Entry<Character, int[]> entry : letters.entrySet()) {
            ranges[i++] = entry.getValue();
        }
        return mergeRanges(ranges);
    }

    private List<Integer> mergeRanges(int[][] ranges) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(ranges, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int left = ranges[0][0];
        int right = ranges[0][1];
        for (int i = 1; i < ranges.length; i++) {
            int leftNew = ranges[i][0];
            int rightNew = ranges[i][1];
            if (leftNew > right) {
                // 如果无交集，此时直接加入结果集，然后更新
                result.add(right - left + 1);
                left = leftNew;
                right = rightNew;
            } else {
                // 有交集，则更新右边界
                right = Math.max(right, rightNew);
            }
        }
        result.add(right - left + 1);
        return result;
    }


    @Test(description = "")
    public void test() throws Exception {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(partitionLabels("eccbbbbdec"));
        System.out.println(partitionLabels("abcbafeds"));

    }
}
