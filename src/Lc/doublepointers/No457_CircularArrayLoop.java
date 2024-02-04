package Lc.doublepointers;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/circular-array-loop/description/">判断数组是否有环</a>
 **/
public class No457_CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean res = fastAndSlow(nums, i);
            if (res) {
                return true;
            }
        }
        return false;
    }

    private boolean fastAndSlow(int[] nums, int start) {
        int slow = start, fast = start;
        while (true) {
            int slowOne = moveOneStep(nums, slow);
            if (nums[slow] * nums[slowOne] < 0 || slow == slowOne) {
                return false;
            }
            int fastOne = moveOneStep(nums, fast);
            if (nums[fast] * nums[fastOne] < 0 || fastOne == fast) {
                return false;
            }
            int fastTwo = moveOneStep(nums, fastOne);
            if (nums[fastOne] * nums[fastTwo] < 0 || fastTwo == fastOne) {
                return false;
            }
            if (fastTwo == slowOne) {
                return true;
            }
            slow = slowOne;
            fast = fastTwo;
        }
    }

    public int moveOneStep(int[] nums, int start) {
        int steps = nums[start];
        steps = steps % nums.length;
        return (start + nums.length + steps) % nums.length;
    }

    @Test(description = "")
    public void test() throws Exception {
//        Assert.assertTrue(circularArrayLoop(new int[]{2, -1, 1, 2, 2}));
//        Assert.assertFalse(circularArrayLoop(new int[]{-1, -2, -3, -4, -5, 6}));
//        Assert.assertTrue(circularArrayLoop(new int[]{1, -1, 5, 1, 4}));
        Assert.assertFalse(circularArrayLoop(new int[]{-1, -2, -3, -4, -5}));

    }


}
