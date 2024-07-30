package lc150;

import DataStruct.ListNode;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No82DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (pre != null && pre.next != null) {
            ListNode pivot = pre.next;
            int value = pivot.val;
            ListNode pivotN = pivot.next;
            while (pivotN != null && pivotN.val == value) {
                pivotN = pivotN.next;
            }
            if (pivotN != pivot.next) {
                pre.next = pivotN;
            } else {
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 3, 4, 4, 5, 5);
        System.out.println(deleteDuplicates(head));

        head = ListNode.createListNode(1, 1, 1, 2, 3, 3, 4, 4, 5, 5);
        System.out.println(deleteDuplicates(head));
    }
}
