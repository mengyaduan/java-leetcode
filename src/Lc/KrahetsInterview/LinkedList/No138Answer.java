package Lc.KrahetsInterview.LinkedList;

import org.testng.annotations.Test;

import static Lc.KrahetsInterview.LinkedList.Node.createNode;

/**
 * @see <a href="https://leetcode.com/problems/copy-list-with-random-pointer/description/">复制随机链表</a>
 **/
public class No138Answer {


    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        // 先复制
        while (cur != null) {
            Node item = new Node(cur.val);
            item.next = cur.next;
            cur.next = item;
            cur = cur.next.next;
        }
        //  给random赋值
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // 拆分
        Node headNew = new Node(0);
        cur = head;
        Node curNew = headNew;
        while (cur != null) {
            curNew.next = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            curNew = curNew.next;
        }
        return headNew.next;
    }

    @Test(description = "单测")
    public void test() {
        Node head = createNode(new int[]{1, 5}, new int[]{2, 3}, new int[]{3, -100001}, new int[]{4, 4}, new int[]{5, 2});
        System.out.println(head);
        Node headNew = copyRandomList(head);
        System.out.println(headNew);
    }

}

