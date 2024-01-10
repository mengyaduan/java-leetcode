package Lc.KrahetsInterview.LinkedList;

import DataStruct.ListNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static DataStruct.ListNode.createListNode;

/**
 * @see <a href="https://leetcode.com/problems/delete-node-in-a-linked-list/description/">删除节点</a>
 **/
public class No237 {

    /**
     * 思路：<p>
     **/
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        ListNode head = createListNode(1, 2, 3, 4, 5);
        return new Object[][]{
                {head, head.next.next},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(ListNode head, ListNode target) {
        System.out.println(head);
        deleteNode(target);
        System.out.println(head);

    }

}

