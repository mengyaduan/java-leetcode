package Lc.sort;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

/**
 * @see <a href="https://leetcode.com/problems/sort-characters-by-frequency/">No451 根据频次排序</a>
 **/
public class No451 {

    public String frequencySort(String s) {
        Map<String, Integer> dict = new HashMap<>();
        for (char x : s.toCharArray()) {
            String tmp = String.valueOf(x);
            dict.put(tmp, dict.getOrDefault(tmp, 0) + 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(dict.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
        String res = "";
        for (Map.Entry<String, Integer> item : list) {
            int count = item.getValue();
            while (count > 0) {
                res += item.getKey();
                count--;
            }
        }
        return res;
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {"tree", "eert"},
                {"a", "a"},
                {"abc", "abc"},
                {"eeee", "eeee"},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, String expected) {
        String res = frequencySort(s);
        Assert.assertEquals(res, expected);
    }
}
