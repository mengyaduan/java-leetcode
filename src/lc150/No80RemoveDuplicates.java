package lc150;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No80RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int res = 0;
        // init
        int val = nums[0];
        int count = 0;
        int head = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val && count < 2) {
                res++;
                nums[head] = val;
                head++;
                count++;
            } else if (nums[i] != val) {
                nums[head] = nums[i];
                head++;
                res++;
                val = nums[i];
                count = 1;
            }
        }
        System.out.println(Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}), 7);

    }
}
