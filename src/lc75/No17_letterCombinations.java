package lc75;

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @see <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/?envType=study-plan-v2&envId=leetcode-75">电话号码的组合</a>
 */
public class No17_letterCombinations {

    List<String> res;
    HashMap<String, String> letters;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        initLetter();
        backtrack(digits, 0, new ArrayList<Character>());
        return res;
    }

    private void backtrack(String digits, int idx, ArrayList<Character> path) {
        if (idx >= digits.length()) {
            if (!path.isEmpty()) {
                res.add(path.stream().map(String::valueOf).collect(Collectors.joining()));
            }
            return;
        }
        String round = letters.get(digits.charAt(idx) + "");
        for (int i = 0; i < round.length(); i++) {
            path.add(round.charAt(i));
            backtrack(digits, idx + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public void initLetter() {
        letters = new HashMap<>();
        letters.put("2", "abc");
        letters.put("3", "def");
        letters.put("4", "ghi");
        letters.put("5", "jkl");
        letters.put("6", "mno");
        letters.put("7", "pqrs");
        letters.put("8", "tuv");
        letters.put("9", "wxyz");
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(letterCombinations("23"));

    }
}
