package lc100;

import DataStruct.ListNode;
import org.testng.annotations.Test;

public class No19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode fast = pre;
        ListNode result = pre;
        while (fast.next != null) {
            fast = fast.next;
            if (n > 0) {
                n--;
            } else {
                pre = pre.next;
            }
        }
        pre.next = pre.next.next;
        return result.next;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 4, 5);
        System.out.println(removeNthFromEnd(head, 5));

    }


}
