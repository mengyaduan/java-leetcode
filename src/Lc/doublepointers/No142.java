package Lc.doublepointers;

import DataStruct.ListNode;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/linked-list-cycle-ii/"</a>
 **/
public class No142 {
    /**
     * 解题思路：
     * 弗洛伊德判圈法：https://www.cnblogs.com/ZhaoxiCheung/p/7355369.html
     * <p>
     * 1. 设置快慢指针，如果能相遇，则一定包含圈
     * 2. 在相遇时，将快指针重置到起点，然后调整为单步前进，再次相遇时，两个指针一定在起点。
     **/

    public ListNode detectCycle(ListNode head) {
        ListNode cursorSlow = head;
        ListNode cursorFast = head;
        while (true) {
            if (cursorFast == null || cursorFast.next == null) {
                return null;
            }
            cursorFast = cursorFast.next.next;
            cursorSlow = cursorSlow.next;
            if (cursorFast == cursorSlow) {
                break;
            }

        }
        cursorFast = head;
        while (true) {
            if (cursorFast == cursorSlow) {
                return cursorFast;
            }
            cursorFast = cursorFast.next;
            cursorSlow = cursorSlow.next;
        }
    }


    @Test(description = "单测")
    public void test() throws Exception {
        ListNode head = new ListNode(3);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(0);
        ListNode c = new ListNode(-4);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = a;

        ListNode x = detectCycle(head);
        System.out.println(x.val);
    }
}