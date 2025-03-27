package Lc119;

import DataStruct.ListNode;
import org.testng.annotations.Test;

public class LCR024 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            // 单个节点直接返回
            return head;
        }
        ListNode tmp = head.next;
        ListNode reversed = reverseList(head.next);
        tmp.next = head;
        head.next = null;
        return reversed;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 4, 5);
        System.out.println(reverseList(head));

    }

}
