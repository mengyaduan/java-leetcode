package lc75;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @see <a href="https://leetcode.cn/problems/find-the-difference-of-two-arrays/description/?envType=study-plan-v2&envId=leetcode-75">找出两数组的不同</a>
 */
public class No2215_findDifference {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> n1 = new HashSet();
        HashSet<Integer> n2 = new HashSet();
        for (int item : nums1) {
            n1.add(item);
        }
        for (int item : nums2) {
            n2.add(item);
        }
        for (int item : nums1) {
            n2.remove(item);
        }
        for (int item : nums2) {
            n1.remove(item);
        }

        ArrayList<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(n1));
        res.add(new ArrayList<>(n2));
        return res;
    }
}
