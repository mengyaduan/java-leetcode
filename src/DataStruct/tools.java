package DataStruct;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.Arrays;

import static DataStruct.BinaryTreePrinter.printTree;

/**
 * 刷题工具
 **/
public class tools {
    public static int[] string2IntArray(String s) {
        String[] tmp = StringUtils.split(s, ",");
        return Arrays.stream(tmp).map(String::trim).mapToInt(Integer::parseInt).toArray();
    }

    public static TreeNode createTree(String s) {
        String[] nodes = StringUtils.split(s, ",");
        nodes = Arrays.stream(nodes).map(String::trim).toArray(String[]::new);
        TreeNode[] used = new TreeNode[nodes.length];
        Arrays.fill(used, null);

        int i = 0;
        while (i < nodes.length) {
            if (nodes[i].equals("null")) {
                i++;
                continue;
            }
            TreeNode nodeItem;
            if (used[i] == null) {
                nodeItem = new TreeNode(Integer.parseInt(nodes[i]));
                used[i] = nodeItem;
            } else {
                nodeItem = used[i];
            }
            // 查看是否有左子树
            if (2 * i + 1 < nodes.length && !nodes[2 * i + 1].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[2 * i + 1]));
                nodeItem.left = left;
                used[2 * i + 1] = left;
            }
            if (2 * i + 2 < nodes.length && !nodes[2 * i + 1].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[2 * i + 2]));
                nodeItem.right = right;
                used[2 * i + 2] = right;
            }
            i++;
        }
        // 打印函数
        printTree(used[0]);
        return used[0];
    }

    @Test(description = "")
    public void testc() throws Exception {
        TreeNode head = createTree("3,9,20,12,2,15,7,4,5,6,7,3,2,4,1,2,2");
        System.out.println("");

    }
}

