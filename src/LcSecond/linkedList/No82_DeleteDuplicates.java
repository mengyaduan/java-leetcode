package LcSecond.linkedList;

import DataStruct.ListNode;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/">删除有序链表的重复节点</a>
 **/
public class No82_DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode headNew = new ListNode(-123);
        ListNode cur = headNew;
        ListNode item = head;
        while (item != null) {
            int target = item.val;
            ListNode pivot = item.next;
            boolean flag = false;
            while (pivot != null && pivot.val == target) {
                flag = true;
                pivot = pivot.next;
            }
            if (flag) {
                // 如果需要删除，那么直接修改item就行了，cur不用动
                item = pivot;
            } else {
                // 如果不需要删除，那么将item追加到cur后面，item走下一个
                cur.next = item;
                item = item.next;
                cur = cur.next;
                cur.next = null;
            }
        }
        return headNew.next;
    }


    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 3, 3, 4, 4, 5);
        System.out.println(deleteDuplicates(head));
    }

    @Test(description = "")
    public void test1() throws Exception {
        ListNode head = ListNode.createListNode(1, 1, 1, 2, 3, 3, 3, 4, 4, 5);
        System.out.println(deleteDuplicates(head));
    }

    @Test(description = "")
    public void test2() throws Exception {
        ListNode head = ListNode.createListNode(1, 1, 2, 2);
        System.out.println(deleteDuplicates(head));
    }
}

