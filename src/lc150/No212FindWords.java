package lc150;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class No212FindWords {

    List<String> result;
    int[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
        result = new ArrayList<>();
        // 构建字典树
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int m = board.length, n = board[0].length;
        visited = new int[m][n];
        // 遍历矩阵，一旦字典树中有数据，则触发查询
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, m, n, i, j, trie.root);
            }
        }
        return result;
    }

    /**
     * 如何查询？
     * dfs(i, j, root)
     * root的child中存在当前的board[i][j]，说明当前字符可以匹配，标记visit=1
     * 针对上下左右，进行dfs(i', j', root.child[idx])，直到结尾即可
     */

    private void dfs(char[][] board, int m, int n, int i, int j, TNode root) {
        // 如果越界 或者 当前节点已访问 或者 当前root为null  ，直接返回
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] == 1 || root == null) {
            return;
        }
        // 2. 继续往后走，应对 app和application共存的情况
        // 当前字符对应的下标
        int idx = board[i][j] - 'a';
        if (root.child[idx] == null) {
            // 当前字符不匹配，返回
            return;
        }
        // 当前字符匹配
        if (root.child[idx].isLeaf) {
            // 1. 抵达叶节点，将word加入结果集
            result.add(root.child[idx].word);
            // 为了避免重复添加，将该单词从字典树中抹去
            root.child[idx].isLeaf = false;
        }
        visited[i][j] = 1;
        dfs(board, m, n, i - 1, j, root.child[idx]);
        dfs(board, m, n, i + 1, j, root.child[idx]);
        dfs(board, m, n, i, j - 1, root.child[idx]);
        dfs(board, m, n, i, j + 1, root.child[idx]);
        visited[i][j] = 0;
    }

    class Trie {
        TNode root;

        public Trie() {
            root = new TNode();
        }

        public void insert(String word) {
            TNode cur = root;
            for (int i = 0; i < word.toCharArray().length; i++) {
                char item = word.toCharArray()[i];
                int idx = item - 'a';
                if (cur.child[idx] == null) {
                    cur.child[idx] = new TNode();
                }
                cur = cur.child[idx];
                if (i == word.length() - 1) {
                    // 已经到了最后一个
                    cur.isLeaf = true;
                    cur.word = word;
                }
            }
        }

        public boolean search(String word) {
            TNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char item = word.charAt(i);
                int idx = item - 'a';
                if (cur.child[idx] == null) {
                    return false;
                }
                cur = cur.child[idx];
                if (i == word.length() - 1) {
                    return cur.isLeaf;
                }
            }
            return false;
        }

        public boolean startsWith(String prefix) {
            TNode cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                char item = prefix.charAt(i);
                int idx = item - 'a';
                if (cur.child[idx] == null) {
                    return false;
                }
                cur = cur.child[idx];
            }
            return true;

        }
    }

    class TNode {
        boolean isLeaf;
        String word;
        TNode[] child;

        TNode() {
            isLeaf = false;
            child = new TNode[26];
        }
    }


    @Test(description = "")
    public void test() throws Exception {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        System.out.println(findWords(board, new String[]{"oath", "pea", "eat", "rain"}));
    }

}
