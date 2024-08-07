package lc150;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No17LetterCombinations {

    List<String> res;
    HashMap<Character, String> helper;

    public List<String> letterCombinations(String digits) {
        initHelper();
        res = new ArrayList<>();
        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    private void backtrack(String digits, int idx, StringBuilder path) {
        if (idx >= digits.length()) {
            if (path.length() > 0) {
                res.add(path.toString());
            }
            return;
        }
        char item = digits.charAt(idx);
        char[] d = helper.get(item).toCharArray();
        for (int i = 0; i < d.length; i++) {
            path.append(d[i]);
            backtrack(digits, idx + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }

    private void initHelper() {
        helper = new HashMap<>();
        helper.put('2', "abc");
        helper.put('3', "def");
        helper.put('4', "ghi");
        helper.put('5', "jkl");
        helper.put('6', "mno");
        helper.put('7', "pqrs");
        helper.put('8', "tuv");
        helper.put('9', "wxyz");
    }


    @Test(description = "")
    public void test() throws Exception {
        List<String> x = letterCombinations("23");
        for (String m : x) {
            System.out.println(m);
        }

    }

}
