package lc150;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No26RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int cur = 0;
        int nowAt = 0;

        while (nowAt < nums.length) {
            if (nums[nowAt] != nums[cur]) {
                cur++;
                nums[cur] = nums[nowAt];
            }
            nowAt++;
        }
        System.out.println(Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        return cur + 1;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}), 5);

    }
}
