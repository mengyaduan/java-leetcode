package Lc;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

/**
 * @author yameng.dym
 * 单向链表
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createListNode(int... nums) {
        if (nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode item = new ListNode(nums[i]);
            cur.next = item;
            cur = cur.next;
        }
        return head;
    }


    @Override
    public String toString() {
        ListNode cur = this;
        ArrayList<Integer> res = new ArrayList<>();
        while (cur != null) {
            res.add(cur.val);
            cur = cur.next;
        }
        return StringUtils.join(res, " → ");
    }
}