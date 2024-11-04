package lc100;

import DataStruct.ListNode;
import org.testng.annotations.Test;

public class No160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        boolean switch1 = false;
        boolean switch2 = false;
        while (p1 != p2) {
            // 因为最终遍历的长度是一样的，所以p1不可能为null，一旦p1为null，p2一定为null
            if (p1.next == null && !switch1) {
                p1 = headB;
                switch1 = true;
            } else {
                p1 = p1.next;
            }
            if (p2.next == null && !switch2) {
                p2 = headA;
                switch2 = true;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }

    @Test(description = "")
    public void test2() throws Exception {
        ListNode a = ListNode.createListNode(1, 2, 3, 4, 5);
        ListNode b = ListNode.createListNode(6);
        ListNode x = getIntersectionNode(a, b);
        System.out.println(x);
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode a = ListNode.createListNode(1, 2, 3, 4, 5);
        ListNode b = ListNode.createListNode(6);
        b.next = a.next.next;
        ListNode x = getIntersectionNode(a, b);
        System.out.println(x);
    }
}
