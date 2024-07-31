package lc150;

import org.testng.annotations.Test;

public class LRUtest {

    @Test(description = "")
    public void test2() throws Exception {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2, 1);
        System.out.println(lruCache.get(2));
    }

    @Test(description = "")
    public void test() throws Exception {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
