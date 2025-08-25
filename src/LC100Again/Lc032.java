package LC100Again;


import java.util.HashMap;

public class Lc032 {


    public Node copyRandomList(Node head) {
        HashMap<Node, Node> old2New = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node item = new Node(cur.val);
            old2New.put(cur, item);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            old2New.get(cur).next = old2New.get(cur.next);
            old2New.get(cur).random = old2New.get(cur.random);
            cur = cur.next;
        }
        return old2New.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

