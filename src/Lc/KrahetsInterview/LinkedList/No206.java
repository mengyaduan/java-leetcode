package Lc.KrahetsInterview.LinkedList;

import DataStruct.ListNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static DataStruct.ListNode.createListNode;

/**
 * @see <a href="https://leetcode.com/problems/reverse-linked-list/description/">反转列表</a>
 **/
public class No206 {


    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = new ListNode(head.val);
        ListNode cur = result;
        head = head.next;
        while (head != null) {
            result = new ListNode(head.val);
            result.next = cur;
            cur = result;
            head = head.next;
        }
        return result;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                {createListNode(1, 2, 3, 4, 5, 6)},
                {createListNode()},
                {createListNode(1)},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(ListNode head) {
        ListNode res = reverseList(head);
        if (res != null) {
            System.out.println(res);
        } else {
            System.out.println("null");
        }

    }

}

