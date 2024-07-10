package lc150;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @see <a href="https://leetcode.com/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No189Rotate {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        int n = nums.length;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        System.out.println(Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int x = nums[i];
            nums[i] = nums[j];
            nums[j] = x;
            i++;
            j--;
        }
    }

    @Test(description = "")
    public void test() throws Exception {

        rotate(new int[]{-1, -100, 3, 99}, 2);

        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 2);
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 1);
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 28);
    }
}
