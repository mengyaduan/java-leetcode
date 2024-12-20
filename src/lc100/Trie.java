package lc100;

import com.apple.eawt.AppEvent;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Trie {

    /**
     * 起点的集合
     */
    HashMap<Character, Vertex> vertices;

    /**
     * 每个起点对应的边的集合
     */
    HashMap<Character, ArrayList> edges;

    public Trie() {
        vertices = new HashMap<>();

    }

    public void insert(String word) {
        char[] w = word.toCharArray();
        Vertex dummy = new Vertex('-', 1);
        if (!vertices.containsKey(w[0])) {
            // 没有作为起点出现过，直接insert
            vertices.put(w[0], dummy);
            Vertex lastV = dummy;
            for (int i = 0; i < w.length; i++) {
                Vertex item = new Vertex(w[i], i == w.length - 1 ? 2 : 0);
                lastV.nextSet.add(w[i]);
                lastV.nextMap.put(w[i], item);
                lastV = item;
            }
        } else {
            Vertex cur = vertices.get(w[0]);
            int k = 0;
            while (k < w.length && cur.nextSet.contains(w[k])) {
                cur = cur.nextMap.get(w[k]);
                k++;
            }
            if (k == w.length) {
                cur.label = 2;
                return;
            }
            Vertex lastV = cur;
            for (int i = k; i < w.length; i++) {
                Vertex item = new Vertex(w[i], i == w.length - 1 ? 2 : 0);
                lastV.nextSet.add(w[i]);
                lastV.nextMap.put(w[i], item);
                lastV = item;
            }
        }
    }

    public boolean search(String word) {
        char[] w = word.toCharArray();
        if (!vertices.containsKey(w[0])) {
            return false;
        }
        Vertex cur = vertices.get(w[0]);
        for (int i = 0; i < w.length; i++) {
            HashSet<Character> candidates = cur.nextSet;
            if (!candidates.contains(w[i])) {
                return false;
            }
            cur = cur.nextMap.get(w[i]);
        }
        return cur.label >= 2;
    }

    public boolean startsWith(String prefix) {
        char[] w = prefix.toCharArray();
        if (!vertices.containsKey(w[0])) {
            return false;
        }
        Vertex cur = vertices.get(w[0]);
        for (int i = 0; i < w.length; i++) {
            HashSet<Character> candidates = cur.nextSet;
            if (!candidates.contains(w[i])) {
                return false;
            }
            cur = cur.nextMap.get(w[i]);
        }
        return true;
    }

    @Test(description = "")
    public void test() throws Exception {
        Trie t = new Trie();
        t.insert("apple");
        Assert.assertFalse(t.search("app"));
        Assert.assertTrue(t.search("apple"));
        Assert.assertFalse(t.search("ab"));
        t.insert("appleakf");
        Assert.assertTrue(t.search("apple"));
        Assert.assertTrue(t.startsWith("app"));
        t.insert("apart");
        Assert.assertFalse(t.startsWith("art"));
        Assert.assertTrue(t.search("apart"));
        t.insert("app");
        Assert.assertTrue(t.search("app"));
        Assert.assertTrue(t.startsWith("app"));
        t.insert("f");
        Assert.assertTrue(t.search("f"));
        Assert.assertTrue(t.startsWith("f"));
    }

}

class Vertex {
    char value;
    /**
     * 默认0， 1是起始点，2是终结点, 3是both
     */
    int label;
    /**
     * 下一跳的集合
     */
    HashSet<Character> nextSet;
    HashMap<Character, Vertex> nextMap;

    Vertex(char value, int label) {
        this.value = value;
        this.label = label;
        nextSet = new HashSet<>();
        nextMap = new HashMap<>();
    }
}
