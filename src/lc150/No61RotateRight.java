package lc150;

import DataStruct.ListNode;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/rotate-list/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No61RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        if (size == 0 || (k %= size) == 0) {
            return head;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode fast = dummyHead, slow = dummyHead;
        while (fast != null && fast.next != null) {
            if (k == 0) {
                slow = slow.next;
            } else {
                k--;
            }
            fast = fast.next;
        }
        fast.next = dummyHead.next;
        dummyHead.next = slow.next;
        slow.next = null;
        return dummyHead.next;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 4, 5);
        System.out.println(rotateRight(head, 10));

    }
}
