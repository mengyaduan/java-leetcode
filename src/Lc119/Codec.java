package Lc119;

import DataStruct.TreeNode;
import org.testng.annotations.Test;
import sun.nio.ch.SelectorImpl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

import static DataStruct.BinaryTreePrinter.printTree;
import static DataStruct.tools.createTree;

/**
 * LCR 048
 */
public class Codec {

    TreeNode dummy = new TreeNode(-9999);

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        ArrayList<String> result = new ArrayList<>();
        // 层序遍历，将左右的null都扔进队列中
        Deque<TreeNode> helper = new ArrayDeque<>();
        helper.addLast(root);
        while (!helper.isEmpty()) {
            int size = helper.size();
            for (int i = 0; i < size; i++) {
                TreeNode item = helper.pollFirst();
                if (item == dummy) {
                    result.add("null");
                    continue;
                } else {
                    result.add(item.val + "");
                }
                helper.addLast(item.left == null ? dummy : item.left);
                helper.addLast(item.right == null ? dummy : item.right);
            }
        }
        // 将result末尾的null都删除
        int idx = result.size() - 1;
        while (idx >= 0 && result.get(idx).equals("null")) {
            idx--;
        }
        return result.subList(0, idx + 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        String[] nodeStr = data.substring(1, data.length() - 1).split(",");
        Deque<TreeNode> helper = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodeStr[0]));
        helper.addLast(root);
        int idx = 1;
        while (!helper.isEmpty()) {
            TreeNode item = helper.pollFirst();
            if (idx >= nodeStr.length) {
                break;
            }
            if (item == dummy) {
                // 如果弹出的是null节点，什么都不要做
            } else {
                if (nodeStr[idx].equals("null")) {
                    item.left = null;
                } else {
                    item.left = new TreeNode(Integer.parseInt(nodeStr[idx]));
                    helper.addLast(item.left);
                }
                idx++;
                if (idx >= nodeStr.length) {
                    break;
                }
                if (nodeStr[idx].equals("null")) {
                    item.right = null;
                } else {
                    item.right = new TreeNode(Integer.parseInt(nodeStr[idx].trim()));
                    helper.addLast(item.right);
                }
                idx++;
            }
        }
        return root;
    }


    @Test(description = "")
    public void test() throws Exception {
//        TreeNode root = createTree("1,2,3,null,null,4,5, null,null,null,null,6,null,null,7");
//        System.out.println(serialize(root));

        TreeNode xx = deserialize("[1,2,3,null,null,4,5,null,null,6,null,7]");
        printTree(xx);


    }

}