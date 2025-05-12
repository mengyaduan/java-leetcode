package Lc119;

import DataStruct.TrieNode;
import org.testng.annotations.Test;

/**
 * LCR 066
 */
public class MapSum {

    NodeWithNum root;
    int res;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new NodeWithNum();
    }

    public void insert(String key, int val) {
        NodeWithNum cur = root;
        for (char c : key.toCharArray()) {
            if (cur.child[c - 'a'] == null) {
                cur.child[c - 'a'] = new NodeWithNum();
            }
            cur = cur.child[c - 'a'];
        }
        cur.isEnd = true;
        cur.num = val;
    }

    public int sum(String prefix) {
        // 找到prefix节点
        NodeWithNum cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.child[c - 'a'] == null) {
                // 前缀不存在，直接返回0
                return 0;
            }
            cur = cur.child[c - 'a'];
        }
        res = 0;
        dfs(cur);
        return res;
    }

    // 计算cur下面所有num的和
    private void dfs(NodeWithNum cur) {
        if (cur == null) {
            return;
        }
        res += cur.num;
        for (int i = 0; i < 26; i++) {
            dfs(cur.child[i]);
        }
    }
}

class NodeWithNum {
    public NodeWithNum[] child;
    public boolean isEnd;
    public int num;

    public NodeWithNum() {
        this.child = new NodeWithNum[26];
        this.isEnd = false;
        this.num = 0;
    }
}
