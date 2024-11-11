package lc100;

import DataStruct.ListNode;
import org.testng.annotations.Test;

public class No24 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode first = cur;
            cur = cur.next.next;
            // 交换first和 first.next
            pre.next = first.next;
            pre = pre.next;
            pre.next = first;
            pre = pre.next;
            first.next = cur;
        }
        return dummyHead.next;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 4, 5, 6);
        System.out.println(swapPairs(head));

    }
}
