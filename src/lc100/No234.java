package lc100;

import DataStruct.ListNode;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class No234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return head != null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        boolean isOdd = true;
        if (fast == null) {
            // 偶数
            isOdd = false;
        }
        ListNode cur1 = head, cur2 = reverseList(isOdd ? slow.next : slow);
        while (cur2 != null && cur1.val == cur2.val) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur2 == null;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode headNew = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return headNew;
    }

    @DataProvider(name = "unit")
    public Object[][] unit() {
        return new Object[][]{
                {ListNode.createListNode(1, 2, 3, 2, 1), true},
                {ListNode.createListNode(1, 2), false},
                {ListNode.createListNode(1, 2, 3, 3, 2, 1), true},
                {ListNode.createListNode(1), true},
                {ListNode.createListNode(1, 2), false},
        };
    }

    @Test(description = "", dataProvider = "unit")
    public void test(ListNode head, boolean res) throws Exception {
        Assert.assertEquals(isPalindrome(head), res);

    }


}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null && head.next == null){
            return true;
        }

        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null, curr = slow.next;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode left = head, right = prev;
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
}