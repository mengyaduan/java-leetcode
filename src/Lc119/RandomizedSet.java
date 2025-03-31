package Lc119;

import org.testng.annotations.Test;

import java.util.*;

/**
 * LRC030
 */
public class RandomizedSet {

    HashMap<Integer, Integer> map;
    int[] nums;
    // 最后一个可用的
    int lastIdx;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        map = new HashMap<>();
        nums = new int[200000];
        lastIdx = 0;
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, lastIdx);
        nums[lastIdx] = val;
        lastIdx++;
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int loc = map.get(val);
        map.remove(val);
        // 将lastIdx前一个和当前位置置换，同时更新前一个val对应的值，然后将lastIdx--
        lastIdx--;
        if (nums[lastIdx] != nums[loc]) {
            nums[loc] = nums[lastIdx];
            map.put(nums[lastIdx], loc);
        }
        return true;
    }


    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Random random = new Random();
        int x = random.nextInt(lastIdx);
        return nums[x];
    }

    @Test(description = "")
    public void test() throws Exception {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(0);
        randomizedSet.insert(1);
        randomizedSet.remove(0);
        randomizedSet.insert(2);
        randomizedSet.remove(1);
        int x = randomizedSet.getRandom();
        System.out.println(x);

    }

}
