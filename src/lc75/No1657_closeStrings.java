package lc75;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.cn/problems/determine-if-two-strings-are-close/description/?envType=study-plan-v2&envId=leetcode-75">确定两个字符串是否接近</a>
 */
public class No1657_closeStrings {

    public boolean closeStrings(String word1, String word2) {
        HashMap<Character, Integer> w1 = new HashMap<>();
        HashMap<Character, Integer> w2 = new HashMap<>();
        for (Character item : word1.toCharArray()) {
            w1.put(item, w1.getOrDefault(item, 0) + 1);
        }
        for (Character item : word2.toCharArray()) {
            if (!w1.containsKey(item)) {
                return false;
            }
            w2.put(item, w2.getOrDefault(item, 0) + 1);
        }
        // 元素的个数相同 && 具有相同的组成结构（例如3个A和3个C可以理解成是一样的）
        if (w1.size() != w2.size()) {
            // 字符数量都不一样，一定不可能接近
            return false;
        }
        HashMap<Integer, Integer> numOfCharacter1 = new HashMap<>();
        HashMap<Integer, Integer> numOfCharacter2 = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : w1.entrySet()) {
            // map的组成形式为：出现M次的字符一共有N组，M：N
            numOfCharacter1.put(entry.getValue(), numOfCharacter1.getOrDefault(entry.getValue(), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : w2.entrySet()) {
            // map的组成形式为：出现M次的字符一共有N组，M：N
            numOfCharacter2.put(entry.getValue(), numOfCharacter2.getOrDefault(entry.getValue(), 0) + 1);
        }
        if (numOfCharacter1.size() != numOfCharacter2.size()) {
            return false;
        }
        // 开始对比n1，n2的
        for (Map.Entry<Integer, Integer> entry : numOfCharacter1.entrySet()) {
            int m = entry.getKey();
            int n = entry.getValue();
            if (!numOfCharacter2.containsKey(m) || numOfCharacter2.get(m) != n) {
                return false;
            }
        }
        return true;
    }
}
