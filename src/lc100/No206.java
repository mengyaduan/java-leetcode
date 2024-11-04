package lc100;

import DataStruct.ListNode;
import org.testng.annotations.Test;

public class No206 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode headNew = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return headNew;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 4, 5);
        System.out.println(reverseList(head));

    }

}
