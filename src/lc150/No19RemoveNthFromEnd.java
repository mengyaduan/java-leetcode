package lc150;

import DataStruct.ListNode;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No19RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        while (fast != null && fast.next != null) {
            if (n == 0) {
                slow = slow.next;
            } else {
                n--;
            }
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 4, 5);
        System.out.println(removeNthFromEnd(head, 5));

    }
}
