package Lc.KrahetsInterview.LinkedList;

import Lc.ListNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static Lc.ListNode.createListNode;

/**
 * @see <a href="https://leetcode.com/problems/merge-two-sorted-lists/description/">合并有序链表</a>
 **/
public class No21 {


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode result = new ListNode();
        ListNode cur = result;
        while (list1 != null && list2 != null) {
            ListNode item = new ListNode();
            if (list1.val <= list2.val) {
                item.val = list1.val;
                list1 = list1.next;
            } else {
                item.val = list2.val;
                list2 = list2.next;
            }
            cur.next = item;
            cur = cur.next;
        }
        if (list1 == null) {
            cur.next = list2;
        } else if (list2 == null) {
            cur.next = list1;
        }
        return result.next;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(4);
        list3.next = new ListNode(5);
        list3.next.next = new ListNode(6);

        return new Object[][]{
                {createListNode(1, 2, 3), createListNode(1, 3, 4)},
                {createListNode(1, 2, 3), createListNode(3, 4, 6)},
                {createListNode(1, 2, 3), createListNode()},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(ListNode list1, ListNode list2) {
        ListNode res = mergeTwoLists(list1, list2);
        System.out.println(res.toString());
    }

}



