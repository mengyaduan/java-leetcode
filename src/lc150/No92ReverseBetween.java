package lc150;

import DataStruct.ListNode;
import org.testng.annotations.Test;

import java.util.List;

import static DataStruct.ListNode.createListNode;

/**
 * @see <a href="https://leetcode.cn/problems/reverse-linked-list-ii/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No92ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count = 1;
        ListNode leftPre = new ListNode();
        leftPre.next = head;
        ListNode rightPre = new ListNode();
        rightPre.next = head;
        while (count < right) {
            if (count < left) {
                leftPre = leftPre.next;
            }
            rightPre = rightPre.next;
            count++;
        }
        // 将收尾截断，取出需要reverse的部分
        ListNode tail = rightPre.next.next;
        rightPre.next.next = null;
        // 记录后续链接点
        ListNode reverseNode = reverse(leftPre.next);
        leftPre.next.next = tail;
        leftPre.next = reverseNode;
        if (left == 1) {
            return leftPre.next;
        } else {
            return head;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode headNew = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return headNew;
    }


    public ListNode reversBetweenAns(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode insertPre = dummyHead;
        // 先找到插入点和左节点
        int count = 1;
        while (count < left) {
            insertPre = insertPre.next;
            count++;
        }
        ListNode leftNode = insertPre.next;
        ListNode pivot = leftNode.next;
        count++;
        while (count <= right) {
            leftNode.next = pivot.next;
            pivot.next = insertPre.next;
            insertPre.next = pivot;
            pivot = leftNode.next;
            count++;
        }
        return dummyHead.next;
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = createListNode(3, 5);
        System.out.println(reversBetweenAns(head, 1, 2));

        head = createListNode(1, 2, 3, 4, 5, 6, 7);
        System.out.println(reversBetweenAns(head, 2, 7));

    }

}
