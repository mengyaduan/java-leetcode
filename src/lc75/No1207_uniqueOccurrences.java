package lc75;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @see <a href="https://leetcode.cn/problems/unique-number-of-occurrences/description/?envType=study-plan-v2&envId=leetcode-75">独一无二的出现次数</a>
 */
public class No1207_uniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> occ = new HashMap<>();
        for (int item : arr) {
            occ.put(item, occ.getOrDefault(item, 0) + 1);
        }
        HashSet<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : occ.entrySet()) {
            if (set.contains(entry.getValue())) {
                return false;
            }
            set.add(entry.getValue());
        }
        return true;
    }

    @DataProvider(name = "unit")
    public Object[][] unit() {
        return new Object[][]{
                {new int[]{1, 2, 2, 1, 1, 3}, true},
                {new int[]{1, 2}, false},
                {new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}, true},
        };
    }

    @Test(description = "", dataProvider = "unit")
    public void test(int[] arr, boolean result) throws Exception {
        Assert.assertEquals(uniqueOccurrences(arr), result);

    }
}
