package lc100;

import DataStruct.ListNode;
import org.testng.annotations.Test;

public class No21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                cur.next = list2;
                break;
            } else if (list2 == null) {
                cur.next = list1;
                break;
            } else {
                if (list1.val <= list2.val) {
                    cur.next = list1;
                    list1 = list1.next;
                } else {
                    cur.next = list2;
                    list2 = list2.next;
                }
                cur = cur.next;
            }
        }
        return head.next;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode h1 = ListNode.createListNode(1, 3, 4, 5, 7);
        ListNode h2 = ListNode.createListNode(2, 4, 8, 10);
        System.out.println(mergeTwoLists(h1, h2));

    }
}
