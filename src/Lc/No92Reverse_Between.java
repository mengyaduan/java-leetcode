package Lc;

import DataStruct.ListNode;
import org.testng.annotations.Test;

import java.util.List;

public class No92Reverse_Between {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        // 定位到left节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        // 边反转，边计数，一共反转right-left+1个
        int count = 0;
        ListNode tail = cur;
        ListNode dummyHead = new ListNode();
        ListNode dummyPre = dummyHead;
        while (count < right - left + 1) {
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = dummyPre.next;
            dummyPre.next = tmp;
            count++;
        }
        // cur是尾部，pre是头部，连接
        pre.next = dummyHead.next;
        tail.next = cur;
        return dummy.next;
    }

    @Test(description = "")
    public void test3() throws Exception {
        ListNode head = ListNode.createListNode(3, 5);
        System.out.println(reverseBetween(head, 1, 2));
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 4, 5);
        System.out.println(reverseBetween(head, 2, 4));
    }

    @Test(description = "")
    public void test2() throws Exception {
        ListNode head = ListNode.createListNode(6);
        System.out.println(reverseBetween(head, 1, 1));
    }
}
