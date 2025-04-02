package Lc119;

import DataStruct.TreeNode;
import javafx.scene.control.cell.CheckBoxListCell;
import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static DataStruct.BinaryTreePrinter.printTree;
import static DataStruct.tools.createTree;

/**
 * LCR043
 */
public class CBTInserter {

    TreeNode root;
    Deque<TreeNode> layer;

    public CBTInserter(TreeNode root) {
        this.root = root;
        layer = new ArrayDeque<>();
        fillLayer(layer, root);
        while (!layer.isEmpty() && layer.peekFirst().left != null && layer.peekFirst().right != null) {
            layer.pollFirst();
        }

    }

    private void fillLayer(Deque<TreeNode> layer, TreeNode root) {
        layer.addLast(root);
        Deque<TreeNode> helper = new ArrayDeque<>();
        helper.addLast(root);
        while (!helper.isEmpty()) {
            TreeNode item = helper.pollFirst();
            if (item.left != null) {
                layer.addLast(item.left);
                helper.addLast(item.left);
            }
            if (item.right != null) {
                layer.addLast(item.right);
                helper.addLast(item.right);
            }
        }
    }

    public int insert(int v) {
        TreeNode item = new TreeNode(v);
        TreeNode father = layer.pollFirst();
        if (father.left == null) {
            father.left = item;
            layer.addFirst(father);
        } else {
            father.right = item;
        }
        layer.addLast(item);
        return father.val;
    }

    public TreeNode get_root() {
        return this.root;
    }


}
