package LcSpring100;

import java.util.ArrayList;
import java.util.HashSet;

public class No349Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> n1 = new HashSet<>();
        for (int num : nums1) {
            n1.add(num);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if (n1.contains(num) && !res.contains(num)) {
                res.add(num);
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        return result;

    }

}
