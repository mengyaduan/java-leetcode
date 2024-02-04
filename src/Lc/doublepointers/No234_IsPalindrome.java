package Lc.doublepointers;

import DataStruct.ListNode;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/palindrome-linked-list/description/"></a>
 **/
public class No234_IsPalindrome {
    // 快慢指针，找到中点
    // 翻转后半部分，生成一个从中点往后倒叙的linkedList
    // 从头遍历，如果能把生成的linkedList遍历完，则说明是回文链表
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode nh = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        while (slow != null) {
            ListNode tmp = new ListNode(slow.val);
            tmp.next = nh;
            nh = tmp;
            slow = slow.next;
        }
        fast = head;
        while (nh != null) {
            if (fast.val == nh.val) {
                fast = fast.next;
                nh = nh.next;
            } else {
                return false;
            }
        }
        return true;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(1, 2, 3, 2, 1);
        Assert.assertTrue(isPalindrome(head));
        ListNode head2 = ListNode.createListNode(1, 2, 3, 3, 2, 1);
        Assert.assertTrue(isPalindrome(head2));
        ListNode head3 = ListNode.createListNode(1, 2, 3, 4, 2, 1);
        Assert.assertFalse(isPalindrome(head3));
        ListNode head4 = ListNode.createListNode(1, 2, 3, 4, 1);
        Assert.assertFalse(isPalindrome(head4));

    }
}

