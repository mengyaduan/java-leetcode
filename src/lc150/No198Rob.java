package lc150;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/house-robber/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No198Rob {


    public int rob(int[] nums) {
        int steal = nums[0], notSteal = 0;
        for (int i = 1; i < nums.length; i++) {
            int tmp = Math.max(notSteal, steal);
            steal = notSteal + nums[i];
            notSteal = tmp;
        }
        return Math.max(steal, notSteal);
    }

    @Test(description = "")
    public void test() throws Exception {

        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));

    }

}
