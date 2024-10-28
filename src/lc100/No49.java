package lc100;

import java.util.*;

public class No49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        // 按照字母表排序，然后字母+数字作为key
        HashMap<String, ArrayList<String>> patternMap = new HashMap<>();
        for (String str : strs) {
            // 获取pattern，检查是否存在
            String patternItem = getPattern(str);
            if (patternMap.containsKey(patternItem)) {
                // 存在则直接put
                patternMap.get(patternItem).add(str);
            } else {
                // 不存在则初始化，并put
                patternMap.put(patternItem, new ArrayList<>(Collections.singletonList(str)));
            }
        }

        return new ArrayList<>(patternMap.values());
    }

    private String getPattern(String str) {
        char[] dict = new char[26];
        for (char c : str.toCharArray()) {
            dict[c - 'a'] += 1;
        }
        String result = "";
        for (int i = 0; i < dict.length; i++) {
            result += dict[i] - 'a' + i + "";
        }
        return result;
    }

}
