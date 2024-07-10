package lc150;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @see <a href="https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No27RemoveElement {
    public int removeElement(int[] nums, int val) {
        int res = 0;
        int cur = 0;
        int nowAt = 0;
        while (nowAt < nums.length) {
            if ((nums[nowAt] ^ val) != 0) {
                res++;
                nums[cur] = nums[nowAt];
                cur++;
            }
            nowAt++;
        }
//        System.out.println(StringUtils.join(Arrays.stream(nums).mapToObj(String::valueOf).toArray(), ","));
        String result = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(result);
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(removeElement(new int[]{3, 2, 2, 3}, 3), 2);
        Assert.assertEquals(removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2), 5);

    }


}
