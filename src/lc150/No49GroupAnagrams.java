package lc150;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No49GroupAnagrams {


    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> helper = new HashMap<>();
        for (String str : strs) {
            String key = getKey(str);
            if (!helper.containsKey(key)) {
                helper.put(key, new ArrayList<>());
            }
            helper.get(key).add(str);
        }
        return new ArrayList<>(helper.values());
    }

    private String getKey(String str) {
        int[] letters = new int[26];
        for (char c : str.toCharArray()) {
            letters[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < letters.length; i++) {
            int count = letters[i];
            char letter = (char) ('a' + i);
            sb.append(letter + "-");
            sb.append(count + "-");
        }
        return sb.toString();
    }


    @Test(description = "")
    public void test() throws Exception {
        List<List<String>> x = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (List<String> item : x) {
            System.out.println(StringUtils.join(item, ","));
        }
    }

    @Test(description = "")
    public void test2() throws Exception {
        List<List<String>> x = groupAnagrams(new String[]{""});
        for (List<String> item : x) {
            System.out.println(StringUtils.join(item, ","));
        }
    }
}
