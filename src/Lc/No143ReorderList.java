package Lc;

import DataStruct.ListNode;
import org.testng.annotations.Test;

public class No143ReorderList {

    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head;
        // 找到中点，验证两个例子后确认，不需要分奇偶
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 反转slow以后的所有节点，用dummyHead指向尾部
        ListNode dummyHead = new ListNode();
        ListNode preDummy = dummyHead;
        while (slow != null) {
            ListNode cur = slow;
            slow = slow.next;
            cur.next = preDummy.next;
            preDummy.next = cur;
        }
        ListNode h1 = head, h2 = dummyHead.next;
        // 合并两个链表，一直处理到h2的最后一个节点
        while (h2.next != null) {
            ListNode right = h2;
            h2 = h2.next;
            right.next = h1.next;
            h1.next = right;
            h1 = h1.next.next;
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 4, 5);
        reorderList(head);
        System.out.println(head);

    }
}
