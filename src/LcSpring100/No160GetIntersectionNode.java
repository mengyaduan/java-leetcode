package LcSpring100;

import DataStruct.ListNode;

public class No160GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1 = new ListNode(-1, headA);
        ListNode cur2 = new ListNode(-1, headB);
        boolean x = true, y = true;
        while (cur1 != cur2) {
            if (cur1.next == null && x) {
                cur1 = headB;
                x = false;
            } else {
                cur1 = cur1.next;
            }
            if (cur2.next == null && y) {
                cur2 = headA;
                y = false;
            } else {
                cur2 = cur2.next;
            }
        }
        return cur1;
    }

}
