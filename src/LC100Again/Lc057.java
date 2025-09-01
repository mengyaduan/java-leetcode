package LC100Again;


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lc057 {


    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        HashMap<Character, String> helper = new HashMap<>();
        helper.put('2', "abc");
        helper.put('3', "def");
        helper.put('4', "ghi");
        helper.put('5', "jkl");
        helper.put('6', "mno");
        helper.put('7', "qprs");
        helper.put('8', "tuv");
        helper.put('9', "wxyz");
        backtrack(digits, 0, new StringBuilder(), result, helper);
        return result;
    }

    private void backtrack(String digits, int idx, StringBuilder path, List<String> result, HashMap<Character, String> helper) {
        if (idx == digits.length()) {
            result.add(path.toString());
            return;
        }
        for (char c : helper.get(digits.charAt(idx)).toCharArray()) {
            path.append(c);
            backtrack(digits, idx + 1, path, result, helper);
            path.deleteCharAt(path.length() - 1);
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("23"));

    }
}
