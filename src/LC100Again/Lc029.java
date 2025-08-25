package LC100Again;


import DataStruct.ListNode;
import org.testng.annotations.Test;

public class Lc029 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head), pre = dummy, cur = dummy;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        while (cur.next != null) {
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }


    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 4, 5);
        System.out.println(removeNthFromEnd(head, 2));
        System.out.println(removeNthFromEnd(head, 4));
    }
}
