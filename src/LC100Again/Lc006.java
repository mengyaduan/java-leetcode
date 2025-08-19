package LC100Again;


import org.apache.commons.lang3.EnumUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc006 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 一样的数，不要再算了
                continue;
            }
            int m = i + 1, n = nums.length - 1;
            while (m < n) {
                if (nums[m] + nums[n] + nums[i] > 0) {
                    n--;
                } else if (nums[m] + nums[n] + nums[i] < 0) {
                    m++;
                } else {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[m], nums[n])));
                    // 如果相等，随便挪一个
                    int cur = nums[m];
                    while (m < n && nums[m] == cur) {
                        m++;
                    }
                }
            }
        }
        return result;
    }


}
