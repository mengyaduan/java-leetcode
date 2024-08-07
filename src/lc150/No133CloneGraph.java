package lc150;

import java.util.*;

/**
 * @see <a href="https://leetcode.cn/problems/clone-graph/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No133CloneGraph {


    public Node cloneGraph(Node node) {
        HashMap<Node, Node> helper = new HashMap<>();
        helper.put(node, new Node(node.val));
        Deque<Node> todo = new ArrayDeque<>();
        todo.addLast(node);
        while (!todo.isEmpty()) {
            Node item = todo.pollFirst();
            for (Node neighbor : item.neighbors) {
                if (!helper.containsKey(neighbor)) {
                    helper.put(neighbor, new Node(neighbor.val));
                    todo.addLast(neighbor);
                }
                helper.get(item).neighbors.add(helper.get(neighbor));
            }
        }
        return helper.get(node);
    }

}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}