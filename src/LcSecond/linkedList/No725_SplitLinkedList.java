package LcSecond.linkedList;

import DataStruct.ListNode;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/split-linked-list-in-parts/description/">拆分链表</a>
 **/
public class No725_SplitLinkedList {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];

        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        if (size > k) {
            // size>k时，先整除，算出余数x后，追加到前面的x个分组
            int average = size / k;
            int rest = size % k;
            int i = 0;
            cur = head;
            while (cur != null) {
                int roundSize = average;
                if (rest > 0) {
                    roundSize = average + 1;
                    rest--;
                }
                ListNode prev = null;
                for (int j = 0; j < roundSize; j++) {
                    if (result[i] == null) {
                        result[i] = cur;
                    }
                    prev = cur;
                    cur = cur.next;
                    if (j == roundSize - 1) {
                        prev.next = null;
                    }
                }
                i++;
            }
        } else {
            // size小于可的话，每个pair至多一个节点
            cur = head;
            int i = 0;
            while (cur != null) {
                result[i] = cur;
                cur = cur.next;
                result[i].next = null;
                i++;
            }
        }
        return result;
    }

    @Test(description = "")
    public void test2() throws Exception {
        ListNode[] res = splitListToParts(ListNode.createListNode(1, 2, 3, 4, 5), 3);
        for (ListNode item : res) {
            System.out.println(item);
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode[] res = splitListToParts(ListNode.createListNode(1, 2, 3, 4, 5), 6);
        for (ListNode item : res) {
            System.out.println(item);
        }
    }
}
