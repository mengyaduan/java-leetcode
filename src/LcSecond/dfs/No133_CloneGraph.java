package LcSecond.dfs;

import org.testng.annotations.Test;

import java.util.*;

/**
 * @see <a href="https://leetcode.com/problems/clone-graph/description/"></a>
 **/
public class No133_CloneGraph {

    Node[] created;
    int[] done;

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        created = new Node[110];
        done = new int[110];
        Deque<Node> helper = new ArrayDeque<>();
        helper.add(node);
        while (!helper.isEmpty()) {
            Node tmp = helper.pollFirst();
            if (done[tmp.val] == 1) {
                // 如果已经处理过，则跳过
                continue;
            }
            // 如果未处理
            if (created[tmp.val] == null){
                Node graphNew = new Node(tmp.val);
                created[tmp.val] = graphNew;
            }
            for (Node item : tmp.neighbors) {
                if (created[item.val] == null) {
                    created[item.val] = new Node(item.val);
                }
                created[tmp.val].neighbors.add(created[item.val]);
                if (done[item.val] == 0) {
                    // 如果这个节点还没处理过，就放进队列
                    helper.addLast(item);
                }
            }
            done[tmp.val] = 1;
        }
        return created[1];
    }


    @Test(description = "")
    public void test() throws Exception {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors = new ArrayList<>(Arrays.asList(n2, n4));
        n2.neighbors = new ArrayList<>(Arrays.asList(n1, n3));
        n3.neighbors = new ArrayList<>(Arrays.asList(n2, n4));
        n4.neighbors = new ArrayList<>(Arrays.asList(n1, n3));

        Node m = cloneGraph(n1);
        System.out.println("");

    }
}



