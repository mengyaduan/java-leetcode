package Lc119;

import DataStruct.ListNode;

public class LCR023 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode head1 = new ListNode(-1, headA);
        ListNode head2 = new ListNode(-1, headB);
        boolean flip1 = false;
        boolean flip2 = false;
        while (head1 != head2) {
            if (head1.next == null && !flip1) {
                head1 = headB;
                flip1 = true;
            } else {
                head1 = head1.next;
            }
            if (head2.next == null && !flip2) {
                head2 = headA;
                flip2 = true;
            } else {
                head2 = head2.next;
            }
        }
        return head1;
    }

}
