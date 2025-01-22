package LcSpring100;

import java.util.*;

public class No373KSmallestPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> helper = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            helper.add(new int[]{nums1[i] + nums2[0], i, 0});
        }
        while (result.size() < k) {
            if (helper.isEmpty()) {
                return null;
            }
            int[] item = helper.poll();
            int i = item[1], j = item[2];
            result.add(new ArrayList<>(Arrays.asList(nums1[i], nums2[j])));
            if (j + 1 < nums2.length) {
                helper.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }
        return result;
    }

}
