package lc150;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/substring-with-concatenation-of-all-words/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No30FindSubstring {


    List<Integer> result;

    public List<Integer> findSubstring(String s, String[] words) {
        result = new ArrayList<>();
        int size = words[0].length();
        for (int i = 0; i < size; i++) {
            // 对于size以内的进行遍历处理
            searchIdx(s, i, words);
        }
        return result;
    }

    /**
     * 从i开始匹配，窗口滑动的长度为size
     */
    private void searchIdx(String s, int start, String[] words) {
        int size = words[0].length();
        int windowSize = size * words.length;

        // 初始化
        HashMap<String, Integer> helper = new HashMap<>();
        for (String word : words) {
            helper.put(word, helper.getOrDefault(word, 0) + 1);
        }
        int wordCnt = helper.keySet().size();
        // 按照size的维度进行前进
        int left = start;
        int right = left;
        while (left + windowSize <= s.length()) {
            if (right - left < windowSize) {
                // 如果窗口不够，直接往后扩展，同时更新helper和cnt
                String toExpand = s.substring(right, right + size);
                if (helper.containsKey(toExpand)) {
                    helper.put(toExpand, helper.get(toExpand) - 1);
                    if (helper.get(toExpand) == 0) {
                        // 在扩展窗口的过程中，有一个字符串满足要求了
                        wordCnt -= 1;
                    }

                }
                right += size;
            } else {
                // 如果窗口==windowSize，此时缩小左边
                String toShrink = s.substring(left, left + size);
                if (helper.containsKey(toShrink)) {
                    helper.put(toShrink, helper.get(toShrink) + 1);
                    if (helper.get(toShrink) == 1) {
                        wordCnt += 1;
                    }
                }
                left += size;
            }
            if (right - left == windowSize && wordCnt == 0) {
                result.add(left);
            }
        }

    }

    @Test(description = "")
    public void test2() throws Exception {
        String s = "bcabbcaabbccacacbabccacaababcbb";
        String[] words = {"c", "b", "a", "c", "a", "a", "a", "b", "c"};
        System.out.println(findSubstring(s, words));

    }

}
