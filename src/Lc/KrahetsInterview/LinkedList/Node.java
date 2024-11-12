package Lc.KrahetsInterview.LinkedList;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    /**
     * [1,2], [2,3],[3,5],[4,1],[5,4]
     *
     * @param nums
     * @return
     */
    public static Node createNode(int[]... nums) {
        ArrayList<Node> nodes = new ArrayList<>();
        if (nums.length == 0) {
            return null;
        }
        Node head = new Node(nums[0][0]);
        nodes.add(head);
        Node cur = head;
        for (int i = 1; i < nums.length; i++) {
            Node item = new Node(nums[i][0]);
            cur.next = item;
            cur = cur.next;
            nodes.add(item);
        }

        // 赋随机数，随机数是node顺序的坐标
        for (int i = 0; i < nodes.size(); i++) {
            if (nums[i][1] == -100001) {
                nodes.get(i).random = null;
            } else {
                nodes.get(i).random = nodes.get(nums[i][1] - 1);
            }
        }
        return head;
    }


    @Override
    public String toString() {
        Node cur = this;
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> randoms = new ArrayList<>();
        while (cur != null) {
            res.add(cur.val);
            if (cur.random != null) {
                randoms.add(cur.random.val);
            } else {
                randoms.add(-100001);
            }
            cur = cur.next;
        }
        return StringUtils.join(res, " → ") +
                "\n" +
                StringUtils.join(randoms, " → ");
    }
}
