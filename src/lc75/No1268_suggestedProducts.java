package lc75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/search-suggestions-system/description/?envType=study-plan-v2&envId=leetcode-75">搜索推荐系统</a>
 */
public class No1268_suggestedProducts {

    List<List<String>> result;

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        result = new ArrayList<>();
        Arrays.sort(products);
        HashMap<Character, ArrayList<String>> dict = getDict(products);
        int end = 1;
        while (end <= searchWord.length()) {
            ArrayList<String> res = new ArrayList<>();
            String prefix = searchWord.substring(0, end);
            char key = prefix.charAt(0);
            if (dict.containsKey(key)) {
                for (String product : dict.get(key)) {
                    if (product.startsWith(prefix)) {
                        res.add(product);
                        if (res.size() == 3) {
                            break;
                        }
                    }
                }
            }
            result.add(res);
            end++;
        }
        return result;
    }

    public HashMap<Character, ArrayList<String>> getDict(String[] products) {
        HashMap<Character, ArrayList<String>> dict = new HashMap<>();
        for (String product : products) {
            char k = product.charAt(0);
            if (!dict.containsKey(k)) {
                dict.put(k, new ArrayList<>());
            }
            dict.get(k).add(product);
        }
        return dict;
    }

}

