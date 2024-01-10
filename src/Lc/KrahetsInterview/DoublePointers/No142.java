package Lc.KrahetsInterview.DoublePointers;

import DataStruct.ListNode;

/**
 * @see <a href="https://leetcode.com/problems/linked-list-cycle-ii/">环形链表</a>
 **/
public class No142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            // 无圈
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}

