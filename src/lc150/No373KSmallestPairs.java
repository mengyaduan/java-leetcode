package lc150;

import org.testng.annotations.Test;

import java.util.*;

public class No373KSmallestPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<String> used = new HashSet<>();
        used.add("0-0");
        PriorityQueue<int[]> helper = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        helper.add(new int[]{nums1[0] + nums2[0], 0, 0});
        while (!helper.isEmpty()) {
            int[] item = helper.poll();
            result.add(new ArrayList<>(Arrays.asList(nums1[item[1]], nums2[item[2]])));
            if (result.size() == k) {
                break;
            }
            // 插入下一个可能的数对
            if (item[1] + 1 < nums1.length && !used.contains((item[1] + 1) + "-" + item[2])) {
                helper.add(new int[]{nums1[item[1] + 1] + nums2[item[2]], item[1] + 1, item[2]});
                used.add((item[1] + 1) + "-" + item[2]);
            }
            if (item[2] + 1 < nums2.length && !used.contains(item[1] + "-" + (item[2] + 1))) {
                helper.add(new int[]{nums1[item[1]] + nums2[item[2] + 1], item[1], item[2] + 1});
                used.add(item[1] + "-" + (item[2] + 1));
            }
        }
        return result;
    }


    @Test(description = "")
    public void test() throws Exception {
        List<List<Integer>> s = kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
        System.out.println(s);

    }

}
