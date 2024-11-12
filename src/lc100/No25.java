package lc100;

import DataStruct.ListNode;
import org.testng.annotations.Test;

public class No25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode dummyHead = new ListNode(0, head);
        ListNode pre = dummyHead;
        ListNode cur = head;
        boolean flag = true;
        while (flag) {
            ListNode temp = cur;
            // 前进到下一个需要处理的节点
            for (int i = 0; i < k; i++) {
                if (cur == null) {
                    flag = false;
                    break;
                }
                cur = cur.next;
            }
            if (!flag) {
                // 本轮不足k个，不需要翻转
                break;
            }
            // 翻转本轮的k个节点
            ListNode h = new ListNode(0, null);
            ListNode tail = temp;
            for (int i = 0; i < k; i++) {
                ListNode reverseNode = temp;
                temp = temp.next;
                reverseNode.next = h.next;
                h.next = reverseNode;
            }
            pre.next = h.next;
            tail.next = cur;
            pre = tail;
        }
        return dummyHead.next;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 4, 5, 6);
        System.out.println(reverseKGroup(head, 2));

    }
}
