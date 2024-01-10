package Lc.KrahetsInterview.LinkedList;

import DataStruct.ListNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static DataStruct.ListNode.createListNode;

/**
 * @see <a href="https://leetcode.com/problems/partition-list/description/">分隔链表</a>
 **/
public class No86 {

    /**
     * 思路：<p>
     * 指针：一个用来遍历，一个用来标记第一个大于等于x的节点的父节点
     **/

    public ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode(10000);
        res.next = head;
        ListNode insertIndex = null;
        ListNode curMinusOne = res;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val >= x) {
                // 如果当前的节点大于等于x，如果insertIndex是null，则标记，否则不处理
                if (insertIndex == null) {
                    insertIndex = curMinusOne;
                }
            } else if (cur.val < x) {
                // 在插入节点之后 && 小于x的，才需要挪位置
                if (insertIndex != null) {
                    ListNode item = cur;
                    cur = cur.next;
                    curMinusOne.next = item.next;
                    item.next = insertIndex.next;
                    insertIndex.next = item;
                    insertIndex = insertIndex.next;
                    // Note: 这里需要单独处理cur和minusOne，所以continue
                    continue;
                }
            }
            curMinusOne = cur;
            cur = cur.next;
        }
        return res.next;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                {createListNode(2, 5, 1, 2, 5, 2), 5},
                {createListNode(4, 5, 5, 5, 5, 5), 5},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(ListNode head, int x) {
        ListNode res = partition(head, x);
        System.out.println(res);


    }

}

