package LcSpring100;

import DataStruct.ListNode;
import org.testng.annotations.Test;

public class No82DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        ListNode starter = null;
        ListNode cur = head;
        while (cur != null) {
            if (starter == null) {
                starter = cur;
            }
            cur = starter.next;
            while (cur != null && cur.val == starter.val) {
                // 找到所有的重复
                cur = cur.next;
            }
            if (cur == starter.next) {
                // 说明没有重复,starter可以加入结果
                pre.next = starter;
                pre = pre.next;
                starter.next = null;
            }
            starter = null;
        }
        return dummy.next;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 2);
        System.out.println(deleteDuplicates(head));

    }
}
