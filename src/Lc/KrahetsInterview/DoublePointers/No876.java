package Lc.KrahetsInterview.DoublePointers;

import Lc.ListNode;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static Lc.ListNode.createListNode;

/**
 * @see <a href="https://leetcode.com/problems/middle-of-the-linked-list/description/">找到链表的中点</a>
 **/
public class No876 {

    public ListNode middleNode(ListNode head) {
        ListNode i = head;
        ListNode j = head;
        while (j != null && j.next != null) {
            i = i.next;
            j = j.next.next;
        }
        return i;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                //
                {createListNode(1, 2, 3, 4, 5), new ListNode(3)},
                {createListNode(1, 2, 3, 4, 5, 6), new ListNode(4)},
                {createListNode(1), new ListNode(1)},
                {createListNode(1, 2), new ListNode(2)},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(ListNode head, ListNode expected) {
        ListNode res = middleNode(head);
        Assert.assertEquals(res.val, expected.val);

    }

}

