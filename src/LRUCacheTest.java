import org.testng.annotations.Test;

public class LRUCacheTest {
    @Test(description = "")
    public void testldkjafl() throws Exception {
        int capacity = 3;
        LRUCache lRUCache = new LRUCache(capacity);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        lRUCache.put(3, 3);
        lRUCache.put(4, 4);
        lRUCache.get(4);
        lRUCache.get(3);
        lRUCache.get(2);
        lRUCache.get(1);
        lRUCache.put(5, 5);
        lRUCache.get(1);
        lRUCache.get(2);
        lRUCache.get(3);
        lRUCache.get(4);
        lRUCache.get(3);
        lRUCache.get(5);

    }

    @Test(description = "")
    public void testBad() throws Exception {
        String[] opt = {"LRUCache", "put", "put", "put", "put", "put", "get", "put", "get", "get", "put", "get", "put", "put", "put", "get", "put", "get", "get", "get", "get", "put", "put", "get", "get", "get", "put", "put", "get", "put", "get", "put", "get", "get", "get", "put", "put", "put", "get", "put", "get", "get", "put", "put", "get", "put", "put", "put", "put", "get", "put", "put", "get", "put", "put", "get", "put", "put", "put", "put", "put", "get", "put", "put", "get", "put", "get", "get", "get", "put", "get", "get", "put", "put", "put", "put", "get", "put", "put", "put", "put", "get", "get", "get", "put", "put", "put", "get", "put", "put", "put", "get", "put", "put", "put", "get", "get", "get", "put", "put", "put", "put", "get", "put", "put", "put", "put", "put", "put", "put"};
        String[] kv = {"[10]", "[10,13]", "[3,17]", "[6,11]", "[10,5]", "[9,10]", "[13]", "[2,19]", "[2]", "[3]", "[5,25]", "[8]", "[9,22]", "[5,5]", "[1,30]", "[11]", "[9,12]", "[7]", "[5]", "[8]", "[9]", "[4,30]", "[9,3]", "[9]", "[10]", "[10]", "[6,14]", "[3,1]", "[3]", "[10,11]", "[8]", "[2,14]", "[1]", "[5]", "[4]", "[11,4]", "[12,24]", "[5,18]", "[13]", "[7,23]", "[8]", "[12]", "[3,27]", "[2,12]", "[5]", "[2,9]", "[13,4]", "[8,18]", "[1,7]", "[6]", "[9,29]", "[8,21]", "[5]", "[6,30]", "[1,12]", "[10]", "[4,15]", "[7,22]", "[11,26]", "[8,17]", "[9,29]", "[5]", "[3,4]", "[11,30]", "[12]", "[4,29]", "[3]", "[9]", "[6]", "[3,4]", "[1]", "[10]", "[3,29]", "[10,28]", "[1,20]", "[11,13]", "[3]", "[3,12]", "[3,8]", "[10,9]", "[3,26]", "[8]", "[7]", "[5]", "[13,17]", "[2,27]", "[11,15]", "[12]", "[9,19]", "[2,15]", "[3,16]", "[1]", "[12,17]", "[9,1]", "[6,19]", "[4]", "[5]", "[5]", "[8,1]", "[11,7]", "[5,2]", "[9,28]", "[1]", "[2,2]", "[7,4]", "[4,22]", "[7,24]", "[9,26]", "[13,28]", "[11,26]"};
        int cap = Integer.valueOf(kv[0].substring(1, kv[0].length() - 1));
        LRUCache lruCache = new LRUCache(cap);
        for (int i = 1; i < opt.length; i++) {
            String op = opt[i];
            String str = kv[i].substring(1, kv[i].length() - 1);
            if (op.equals("LRUCache")) {
                continue;
            } else if (op.equals("put")) {
                lruCache.put(Integer.valueOf(str.split(",")[0]), Integer.valueOf(str.split(",")[1]));
            } else {
                lruCache.get(Integer.valueOf(str));
            }
        }

    }

    @Test(description = "")
    public void testBad2() throws Exception {
        String[] opt = {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
        String[] kv = {"[2]", "[1,1]", "[2,2]", "[1]", "[3,3]", "[2]", "[4,4]", "[1]", "[3]", "[4]"};
        int cap = Integer.valueOf(kv[0].substring(1, kv[0].length() - 1));
        LRUCache lruCache = new LRUCache(cap);
        for (int i = 1; i < opt.length; i++) {
            String op = opt[i];
            String str = kv[i].substring(1, kv[i].length() - 1);
            if (op.equals("LRUCache")) {
                System.out.print("null,");
                continue;
            } else if (op.equals("put")) {
                lruCache.put(Integer.valueOf(str.split(",")[0]), Integer.valueOf(str.split(",")[1]));
                System.out.print("null,");
            } else {
                int x = lruCache.get(Integer.valueOf(str));
                System.out.print(x + ",");
            }
        }
        System.out.println();

    }
}
