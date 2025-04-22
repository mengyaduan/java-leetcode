package Lc119;

import com.apple.laf.AquaIcon;
import org.testng.annotations.Test;

import java.util.*;

public class LCR061 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 存储已经使用过的pair
        HashMap<String, Integer> helper = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        List<List<Integer>> result = new ArrayList<>();
        int i = 0, j = 0;
        queue.add(new int[]{nums1[i] + nums2[j], i, j});
        while (result.size() < k && !queue.isEmpty()) {
            int[] item = queue.poll();
            int x = item[1], y = item[2];
            result.add(new ArrayList<>(Arrays.asList(nums1[x], nums2[y])));
            if (x + 1 < nums1.length && !helper.containsKey((x + 1) + "_" + y)) {
                queue.add(new int[]{nums1[x + 1] + nums2[y], x + 1, y});
                helper.put((x + 1) + "_" + y, 1);
            }
            if (y + 1 < nums2.length && !helper.containsKey(x + "_" + (y + 1))) {
                queue.add(new int[]{nums1[x] + nums2[y + 1], x, y + 1});
                helper.put(x + "_" + (y + 1), 1);
            }
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] n1 = new int[]{1, 2};
        int[] n2 = new int[]{3};
        System.out.println(kSmallestPairs(n1, n2, 3));

    }

}