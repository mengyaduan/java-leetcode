package lc150;

import DataStruct.ListNode;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/partition-list/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No86Partition {

    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode insertPre = dummyHead;
        ListNode pivot = dummyHead.next;
        while (pivot != null) {
            if (pivot.val >= x) {
                break;
            }
            insertPre = insertPre.next;
            pivot = pivot.next;
        }
        ListNode pre = insertPre;
        while (pivot != null) {
            if (pivot.val >= x) {
                pivot = pivot.next;
                pre = pre.next;
            } else {
                pre.next = pivot.next;
                pivot.next = insertPre.next;
                insertPre.next = pivot;
                insertPre = insertPre.next;
                pivot = pre.next;
            }
        }
        return dummyHead.next;
    }

    @Test(description = "")
    public void test() throws Exception {
//        ListNode head = ListNode.createListNode(1, 4, 3, 2, 5, 2, 1);
//        System.out.println(partition(head, 3));
        ListNode head = ListNode.createListNode(2, 1);
        System.out.println(partition(head, 2));
    }
}
