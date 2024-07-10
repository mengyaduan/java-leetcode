package lc150;

import java.util.*;

/**
 * @see <a href="https://leetcode.com/problems/insert-delete-getrandom-o1/description/?envType=study-plan-v2&envId=top-interview-150">No380</a>
 */
class RandomizedSet {

    HashMap<Integer, Boolean> helper;
    ArrayList<Integer> x;

    public RandomizedSet() {
        helper = new HashMap<>();
    }

    public boolean insert(int val) {
        if (helper.containsKey(val)) {
            return false;
        }
        helper.put(val, true);
        return true;
    }

    public boolean remove(int val) {
        if (helper.containsKey(val)) {
            helper.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        List<Map.Entry<Integer, Boolean>> list = new ArrayList<>(helper.entrySet());
        Random random = new Random();
        int len = list.size();
        return list.get(random.nextInt(len)).getKey();
    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
