package LC100Again;


import org.testng.annotations.Test;

import java.util.*;

public class Lc002 {

    public List<List<String>> groupAnagrams(String[] strs) {
        // key是pattern，value是结果
        HashMap<HashMap<Character, Integer>, ArrayList> patterns = new HashMap<>();
        for (String item : strs) {
            boolean hasMatched = false;
            HashMap<Character, Integer> character = getCharacter(item);
            for (HashMap<Character, Integer> pattern : patterns.keySet()) {
                if (isMatch(character, pattern)) {
                    // 如果符合，则追加
                    hasMatched = true;
                    patterns.get(pattern).add(item);
                    break;
                }
            }
            if (!hasMatched) {
                patterns.put(character, new ArrayList(Collections.singletonList(item)));
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (ArrayList<String> item : patterns.values()) {
            result.addAll(Collections.singleton(item));
        }
        return result;
    }

    private boolean isMatch(HashMap<Character, Integer> character, HashMap<Character, Integer> pattern) {
        if (character.size() != pattern.size()) {
            return false;
        }
        for (Character key : pattern.keySet()) {
            if (!(character.containsKey(key) && character.get(key) == pattern.get(key))) {
                return false;
            }
        }
        return true;
    }

    private HashMap<Character, Integer> getCharacter(String item) {
        HashMap<Character, Integer> result = new HashMap<>();
        for (Character c : item.toCharArray()) {
            result.put(c, result.getOrDefault(c, 0) + 1);
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        List<List<String>> x = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
         x = groupAnagrams(new String[]{""});

        for (List<String> item : x) {
            System.out.println(item);
        }

    }

}
