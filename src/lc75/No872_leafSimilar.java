package lc75;

import DataStruct.TreeNode;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static DataStruct.tools.createTree;

/**
 * @see <a href="https://leetcode.cn/problems/leaf-similar-trees/description/?envType=study-plan-v2&envId=leetcode-75">叶子相似的树</a>
 */
public class No872_leafSimilar {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> r1 = new ArrayList<>();
        ArrayList<Integer> r2 = new ArrayList<>();
        getLeaf(root1, r1);
        getLeaf(root2, r2);
        if (r1.size() != r2.size()) {
            return false;
        }
        for (int i = 0; i < r1.size(); i++) {
            if (!r1.get(i).equals(r2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void getLeaf(TreeNode root, ArrayList<Integer> leaf) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leaf.add(root.val);
            return;
        }
        getLeaf(root.left, leaf);
        getLeaf(root.right, leaf);
    }

    @Test(description = "")
    public void test() throws Exception {
        TreeNode root1 = createTree("3,5,1,6,2,9,8,null,null,7,4");
        TreeNode root2 = createTree("3,5,1,6,7,4,2,null,null,null,null,null,null,9,8");
        System.out.println(leafSimilar(root1, root2));
    }

    @Test(description = "")
    public void test2() throws Exception {
        TreeNode root1 = createTree("1,2,200");
        TreeNode root2 = createTree("1,2,200");
        System.out.println(leafSimilar(root1, root2));


    }
}
