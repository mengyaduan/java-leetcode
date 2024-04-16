package LcSecond.simulation;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/design-hashmap/description/">设计hashmap</a>
 **/
class MyHashMap {

    int[][] hash;

    public MyHashMap() {
        hash = new int[1001][1001];
        for (int i = 0; i < 1001; i++) {
            Arrays.fill(hash[i], -1);
        }
    }

    public void put(int key, int value) {
        int bucketId = getBucketId(key);
        int id = getId(key, bucketId);
        hash[bucketId][id] = value;
    }

    public int get(int key) {
        int bucketId = getBucketId(key);
        int id = getId(key, bucketId);
        return hash[bucketId][id];
    }

    public void remove(int key) {
        int bucketId = getBucketId(key);
        int id = getId(key, bucketId);
        hash[bucketId][id] = -1;
    }

    /**
     * 哈希函数，将key hash到1000个桶，按照题目要求，每个桶大概就1000个数
     */
    private int getBucketId(int key) {
        return key % 1000;
    }

    /**
     * 哈希函数，将key hash到1000个桶，按照题目要求，每个桶大概就1000个数
     */
    private int getId(int key, int bucketId) {
        return key / 1000;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */