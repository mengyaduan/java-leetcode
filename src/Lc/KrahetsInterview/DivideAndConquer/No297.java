package Lc.KrahetsInterview.DivideAndConquer;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import static DataStruct.BinaryTreePrinter.printTree;

/**
 * @see <a href="https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/">二叉树的序列化与反序列化</a>
 **/
public class No297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        LinkedList<TreeNode> helper = new LinkedList<>();
        helper.add(root);

        while (!helper.isEmpty()) {
            TreeNode head = helper.pollFirst();
            if (head == null) {
                res.add("null");
            } else {
                res.add(String.valueOf(head.val));
            }
            if (head != null) {
                helper.add(head.left);
                helper.add(head.right);
            }
        }
        int lastOne = res.size() - 1;
        while (lastOne > 0 && res.get(lastOne).equals("null")) {
            res.remove(lastOne);
            lastOne--;
        }
        StringBuilder result = new StringBuilder();
        for (String item : res) {
            result.append(item).append(",");
        }
        return result.substring(0, result.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        nodes = Arrays.stream(nodes).map(String::trim).toArray(String[]::new);
        if (nodes[0].equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        LinkedList<TreeNode> helper = new LinkedList<>();
        helper.add(root);

        int start = 1;
        while (!helper.isEmpty()) {
            if (start >= nodes.length) {
                break;
            }
            // 从第一个开始，取上两倍helperSize的数
            int count = helper.size();
            while (count > 0) {
                TreeNode tmp = helper.pollFirst();
                count--;
                if (!nodes[start].equals("null")) {
                    tmp.left = new TreeNode(Integer.parseInt(nodes[start]));
                    helper.add(tmp.left);
                }
                start++;
                if (start >= nodes.length) {
                    break;
                }
                if (!nodes[start].equals("null")) {
                    tmp.right = new TreeNode(Integer.parseInt(nodes[start]));
                    helper.add(tmp.right);
                }
                start++;
                if (start >= nodes.length) {
                    break;
                }
            }
        }
        // 打印函数
        printTree(root);
        return root;
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = deserialize("1,2,3,null,null,4,5,6,null,7");
        String x = serialize(root);
        System.out.println(x);

    }

}

