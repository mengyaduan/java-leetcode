package LcSpring100;

import java.util.HashSet;

public class No718FindLengthOvertime {


    public int findLength(int[] nums1, int[] nums2) {
        // 取短的数组作为窗口
        int[] shortN = nums1.length <= nums2.length ? nums1 : nums2;
        int[] longN = nums1.length <= nums2.length ? nums2 : nums1;
        int size = shortN.length;
        while (size > 0) {
            boolean res = findLengthOfSize(size, shortN, longN);
            if (res) {
                return size;
            }
            size--;
        }
        return size;
    }

    private boolean findLengthOfSize(int size, int[] nums1, int[] nums2) {
        // 用滑动窗口，将nums2所有结果存储到map中
        HashSet<String> helper = new HashSet<>();
        int i = 0, j = size;
        while (j <= nums2.length) {
            StringBuilder sb = new StringBuilder();
            for (int k = i; k < j; k++) {
                sb.append(nums2[k] + "_");
            }
            helper.add(sb.toString());
            i++;
            j++;
        }
        // 同样的窗口在nums1中匹配
        i = 0;
        j = size;
        while (j <= nums1.length) {
            StringBuilder sb = new StringBuilder();
            for (int k = i; k < j; k++) {
                sb.append(nums1[k] + "_");
            }
            if (helper.contains(sb.toString())) {
                return true;
            }
            i++;
            j++;
        }
        return false;
    }

}
