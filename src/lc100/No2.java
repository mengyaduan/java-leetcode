package lc100;

import DataStruct.ListNode;
import org.testng.annotations.Test;

public class No2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean flag = false;
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null || l2 != null || flag) {
            int a = l1 == null ? 0 : l1.val;
            l1 = l1 == null ? null : l1.next;
            int b = l2 == null ? 0 : l2.val;
            l2 = l2 == null ? null : l2.next;
            int c = flag ? 1 : 0;
            cur.next = new ListNode((a + b + c) % 10);
            flag = (a + b + c) >= 10;
            cur = cur.next;
        }
        return dummy.next;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode l1 = ListNode.createListNode(1, 2, 3);
        ListNode l2 = ListNode.createListNode(5, 7, 9);
        System.out.println(addTwoNumbers(l1, l2));

    }
}
