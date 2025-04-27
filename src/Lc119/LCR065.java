package Lc119;

import DataStruct.TrieNode;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class LCR065 {

    ArrayList<Integer> res;

    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            insertReverse(root, word);
        }
        res = new ArrayList<>();
        // 对root进行dfs，每次到根节点的时候，记录一下长度
        dfs(root, 0);
        // 对res进行汇总
        return res.size() + res.stream().mapToInt(Integer::intValue).sum();
    }

    private void dfs(TrieNode root, int length) {
//        if (root.child == null) {
//            res.add(length);
//            return;
//        }
        int childCnt = 0;
        for (int i = 0; i < 26; i++) {
            if (root.child[i] != null) {
                childCnt++;
                dfs(root.child[i], length + 1);
            }
        }
        if (childCnt == 0) {
            res.add(length);
        }
    }

    /**
     * 倒序添加！
     */
    public void insertReverse(TrieNode root, String word) {
        TrieNode cur = root;
        char[] wc = word.toCharArray();
        for (int i = wc.length - 1; i >= 0; i--) {
            char c = wc[i];
            if (cur.child[c - 'a'] == null) {
                cur.child[c - 'a'] = new TrieNode();
            }
            cur = cur.child[c - 'a'];

        }
        cur.isEnd = true;
    }


    @Test(description = "")
    public void test() throws Exception {
        String[] x = new String[]{"time", "me", "bell", "belly"};
        System.out.println(minimumLengthEncoding(x));

    }
}
