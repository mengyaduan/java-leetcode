package Lc.dfs;

import DataStruct.TreeNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static DataStruct.BinaryTreePrinter.printTree;
import static DataStruct.tools.createTree;

/**
 * @see <a href="https://leetcode.com/problems/recover-binary-search-tree/description/">恢复二叉搜索树</a>
 **/
public class No99_RecoverBST {

    /**
     * 思路：中序遍历，第一个错误的位置和最后一个错误的位置互换即可
     * <p>
     * 例如：乱序的树[7,9,5,4,null,8,10]，中序结果：4,9,7,8,5,10
     * <p>
     * 首个错位的是（9，7），此时取first=9
     * <p>
     * 最后一个错位的是（8，5），此时取last=5
     * <p>
     * 调换first和last
     **/
    TreeNode first;
    TreeNode last;
    TreeNode pre;

    public void recoverTree(TreeNode root) {
        first = null;
        last = null;
        pre = null;
        dfs(root);
        if (first != null && last != null) {
            int x = last.val;
            last.val = first.val;
            first.val = x;
        }
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (pre != null && pre.val >= root.val) {
            first = first == null ? pre : first;
            last = root;
        }
        dfs(root.left);
        if (pre != null && pre.val >= root.val) {
            first = first == null ? pre : first;
            last = root;
        }
        pre = root;
        dfs(root.right);
    }

    @DataProvider(name = "unit")
    public Object[][] unit() {
        return new Object[][]{
                {"2,3,1"},
                {"1,3,null,null,2"},
                {"3,1,4,null,null,2"},
        };
    }

    @Test(description = "", dataProvider = "unit")
    public void test(String s) throws Exception {
        TreeNode root = createTree(s);
        recoverTree(root);
        printTree(root);
    }


}

