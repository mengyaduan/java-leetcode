package lc150;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import static DataStruct.BinaryTreePrinter.printTree;
import static DataStruct.tools.createTree;

/**
 * @see <a href="https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No114Flatten {

    public void flatten(TreeNode root) {
        flat(root);
    }


    /**
     * 返回展开后的最后一个节点
     *
     * @param root
     * @return
     */
    public TreeNode flat(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftNew = flat(root.left);
        TreeNode rightNew = flat(root.right);
        // 如果左节点有值，找到左节点的最右侧值
        TreeNode temp = leftNew;
        if (temp != null) {
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = rightNew;
            root.left = null;
            root.right = leftNew;
        }
        return root;
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = createTree("1,2,5,3,4,null,6");
        flatten(root);
        printTree(root);

    }
}
