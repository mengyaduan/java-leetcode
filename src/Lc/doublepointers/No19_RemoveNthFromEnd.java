package Lc.doublepointers;

import DataStruct.ListNode;

/**
 * @see <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/"></a>
 **/
public class No19_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}

