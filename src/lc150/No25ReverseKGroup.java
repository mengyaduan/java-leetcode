package lc150;

import DataStruct.ListNode;
import org.testng.annotations.Test;

public class No25ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        int totalCnt = 0;
        ListNode cur = dummy.next;
        while (cur != null) {
            cur = cur.next;
            totalCnt++;
        }
        // 准备遍历，如果剩余的数不够k个了，停止
        ListNode insertion = dummy;
        cur = dummy.next;
        int reversed = 0;
        while (totalCnt - reversed >= k) {
            for (int i = 0; i < k - 1; i++) {
                ListNode item = cur.next;
                cur.next = item.next;
                item.next = insertion.next;
                insertion.next = item;
                reversed++;
            }
            insertion = cur;
            cur = cur.next;
            reversed++;
        }
        return dummy.next;
    }


    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 4, 5, 6, 7);
        System.out.println(reverseKGroup(head, 9));

    }

}
