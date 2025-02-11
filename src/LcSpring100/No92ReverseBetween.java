package LcSpring100;

import DataStruct.ListNode;
import org.testng.annotations.Test;

import javax.crypto.spec.PSource;

public class No92ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode preLeft = dummy;
        ListNode cur = dummy;
        int idx = 0;
        while (idx < right) {
            if (idx < left) {
                preLeft = cur;
                cur = cur.next;
                idx++;
                continue;
            }
            ListNode toMoveHead = cur.next;
            cur.next = toMoveHead.next;
            toMoveHead.next = preLeft.next;
            preLeft.next = toMoveHead;
            idx++;
        }
        return dummy.next;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 4, 5, 6);
        System.out.println(reverseBetween(head, 2, 6));
        head = ListNode.createListNode(1, 2, 3, 4, 5, 6);
        System.out.println(reverseBetween(head, 1, 6));


    }
}
