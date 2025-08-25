package LC100Again;


import DataStruct.ListNode;
import org.testng.annotations.Test;

public class Lc033 {


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 拆成2段
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        // 分别排序
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(fast);
        // 合并结果
        ListNode dummy = new ListNode(), pre = dummy;
        while (h1 != null && h2 != null) {
            if (h1.val <= h2.val) {
                pre.next = h1;
                h1 = h1.next;
            } else {
                pre.next = h2;
                h2 = h2.next;
            }
            pre = pre.next;
        }
        pre.next = h1 == null ? h2 : h1;
        return dummy.next;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(sortList(ListNode.createListNode(3, 4, 5, 12, 2, 6, 8, 1)));
        System.out.println(sortList(ListNode.createListNode(3, 4, 5, 12, 2, 6, 8)));

    }


}
