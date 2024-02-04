package Lc.doublepointers;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/find-the-duplicate-number/description/"></a>
 **/
public class No287_FindDuplicate {
    /**
     * n+1个空里面，填n个数，必有一个重复的。那么value设为下一跳的目标，则连起来以后必成环，使用弗洛伊德判圈，找到环的起点就行了
     **/

    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findDuplicate(new int[]{3, 1, 3, 4, 2}));
        System.out.println(findDuplicate(new int[]{4, 6, 7, 7, 3, 5, 2, 8, 1}));

    }
}

