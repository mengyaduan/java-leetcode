package LC100Again;


import DataStruct.ListNode;
import org.testng.annotations.Test;

public class Lc031 {


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head), pre = dummy;
        boolean canFlip = forwardK(head, k);
        while (canFlip) {
            // pre - 1 - 2 - 3 - 4 - 5
            ListNode cur = pre.next;
            for (int i = 0; i < k - 1; i++) {
                ListNode item = cur.next;
                cur.next = item.next;
                item.next = pre.next;
                pre.next = item;
            }
            pre = cur;
            canFlip = forwardK(cur.next, k);
        }
        return dummy.next;
    }

    private boolean forwardK(ListNode head, int k) {
        ListNode cur = new ListNode(1, head);
        int cnt = 0;
        while (cur.next != null) {
            cur = cur.next;
            cnt++;
            if (cnt == k) {
                break;
            }
        }
        return cnt == k;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(reverseKGroup(ListNode.createListNode(1, 2, 3, 4, 5, 6), 3));
        System.out.println(reverseKGroup(ListNode.createListNode(1, 2, 3, 4, 5, 6), 4));
        System.out.println(reverseKGroup(ListNode.createListNode(1), 1));

    }

}

