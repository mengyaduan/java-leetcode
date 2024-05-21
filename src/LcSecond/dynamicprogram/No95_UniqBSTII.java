package LcSecond.dynamicprogram;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import java.util.*;

import static DataStruct.BinaryTreePrinter.printTree;
import static DataStruct.tools.createTree;

/**
 * @see <a href="https://leetcode.com/problems/unique-binary-search-trees-ii/description/">构建所有BST</a>
 */
public class No95_UniqBSTII {

    HashMap<Integer, ArrayList<TreeNode>> memo;

    public List<TreeNode> generateTrees(int n) {
        memo = new HashMap<>();
        memo.put(0, new ArrayList<>(Collections.singletonList(null)));
        TreeNode head = new TreeNode(1);
        memo.put(1, new ArrayList<>(Collections.singletonList(head)));
        return getTree(n);
    }

    public List<TreeNode> getTree(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        ArrayList<TreeNode> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            // 左子树的集合就是getTree(i-1)
            List<TreeNode> leftChoices = getTree(i - 1);
            // 右子树的集合就是getTree(n-i) +  i
            List<TreeNode> rightChoices = getTree(n - i);
            for (TreeNode leftOne : leftChoices) {
                for (TreeNode rightOne : rightChoices) {
                    // 以各个节点为根节点时，构建一个新的bst
                    TreeNode rootNew = new TreeNode(i);
                    rootNew.left = leftOne;
                    rootNew.right = plusX(rightOne, i);
                    res.add(rootNew);
                }
            }
        }
        memo.put(n, res);
        return res;
    }

    public TreeNode plusX(TreeNode root, int x) {
        if (root == null) {
            return null;
        }
        TreeNode rootNew = new TreeNode();
        rootNew.val = root.val + x;
        rootNew.left = plusX(root.left, x);
        rootNew.right = plusX(root.right, x);
        return rootNew;
    }

    @Test(description = "")
    public void test123() throws Exception {
        List<TreeNode> x = generateTrees(4);
        for (TreeNode t : x) {
            printTree(t);
        }

    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root = createTree("1,2,3,4,5,6");
        TreeNode rootNew = plusX(root, 2);
        printTree(rootNew);

    }
}
