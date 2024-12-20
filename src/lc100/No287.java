package lc100;

import org.testng.Assert;
import org.testng.annotations.Test;

public class No287 {

    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
            if (slow == fast) {
                break;
            }
        }
        // 找到相遇点，将fast归零
        fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[fast];
            if (slow == fast) {
                break;
            }
        }
        return slow;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(findDuplicate(new int[]{1, 3, 4, 2, 2}), 2);
        Assert.assertEquals(findDuplicate(new int[]{3, 1, 3, 4, 2}), 3);
        Assert.assertEquals(findDuplicate(new int[]{3, 3, 3, 3, 3}), 3);

    }


}
