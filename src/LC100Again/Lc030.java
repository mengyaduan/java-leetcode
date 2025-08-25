package LC100Again;


import DataStruct.ListNode;
import org.testng.annotations.Test;

public class Lc030 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head), cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = first.next;
            first.next = second.next;
            cur.next = second;
            second.next = first;
            cur = first;
        }
        return dummy.next;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(swapPairs(ListNode.createListNode(1)));
        System.out.println(swapPairs(ListNode.createListNode(1, 2, 3, 4)));
        System.out.println(swapPairs(ListNode.createListNode(1, 2, 3, 4, 5)));


    }

}
