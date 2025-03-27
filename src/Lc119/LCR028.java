package Lc119;

import org.testng.annotations.Test;

public class LCR028 {


    Node dummy;
    Node tail;

    public Node flatten(Node head) {
        dummy = new Node(-1);
        tail = dummy;
        dfs(head);
        Node result = dummy.next;
        if (result != null) {
            result.prev = null;
        }
        return result;
    }

    public void dfs(Node head) {
        if (head == null) {
            return;
        }
        // 先把head切断
        Node n = head.next;
        if (n != null) {
            head.next = null;
            n.prev = null;
        }
        tail.next = head;
        head.prev = tail;
        tail = head;
        // 如果有子节点，则先遍历子节点
        if (head.child != null) {
            dfs(head.child);
            head.child = null;
        }
        // 继续处理后续节点
        dfs(n);
    }

    @Test(description = "")
    public void test() throws Exception {
        Node[] s = new Node[5];
        for (int i = 1; i < 6; i++) {
            s[i - 1] = new Node(i);
            if (i > 1) {
                s[i - 1].prev = s[i - 2];
                s[i - 2].next = s[i - 1];
            }
        }
        Node m = flatten(s[0]);
        System.out.println(m.val);

    }

    @Test(description = "")
    public void test12() throws Exception {
        Node[] s = new Node[5];
        for (int i = 1; i < 6; i++) {
            s[i - 1] = new Node(i);
            if (i > 1) {
                s[i - 1].prev = s[i - 2];
                s[i - 2].next = s[i - 1];
            }
        }
        Node b1 = new Node(7);
        Node b2 = new Node(8);
        b1.next = b2;
        b2.prev = b1;
        s[1].child = b1;

        Node m = flatten(s[0]);
        System.out.println(m.val);

    }

}

// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    Node(int x) {
        this.val = x;
    }
};
