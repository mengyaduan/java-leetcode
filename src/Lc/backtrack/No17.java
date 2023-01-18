package Lc.backtrack;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/?show=1">No17 电话号码的字母组合</a>
 **/
public class No17 {


    List<String> res = new ArrayList<>();
    HashMap<String, ArrayList<String>> phoneMap = new HashMap<>();


    public List<String> letterCombinations(String digits) {
        phoneMap.put("2", new ArrayList<>(Arrays.asList("a", "b", "c")));
        phoneMap.put("3", new ArrayList<>(Arrays.asList("d", "e", "f")));
        phoneMap.put("4", new ArrayList<>(Arrays.asList("g", "h", "i")));
        phoneMap.put("5", new ArrayList<>(Arrays.asList("j", "k", "l")));
        phoneMap.put("6", new ArrayList<>(Arrays.asList("m", "n", "o")));
        phoneMap.put("7", new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        phoneMap.put("8", new ArrayList<>(Arrays.asList("t", "u", "v")));
        phoneMap.put("9", new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
        String path = "";
        backtrack(path, digits);
        return res;
    }


    public void backtrack(String path, String digits) {
        // 回溯中止条件
        if (digits == null || digits.length() == 0) {
            if (path.length() > 0) {
                res.add(path);
            }
            return;
        }
        String letter = digits.charAt(0) + "";
        for (String item : phoneMap.get(letter)) {
            // 加入路径
            path += item;
            // 继续
            backtrack(path, digits.substring(1));
            // 从路径中删除
            int len = path.length();
            path = path.substring(0, len - 1);
        }
    }


    @Test(description = "")
    public void test1231() throws Exception {
        String dig = "79";
        List<String> x = letterCombinations(dig);
        System.out.println(x);
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {"23", new ArrayList<>(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"))},
                {"", new ArrayList<>(Arrays.asList())},
                {"2", new ArrayList<>(Arrays.asList("a", "b", "c"))},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, List<String> resultExpected) {

        res.clear();
        letterCombinations(s);
        System.out.println(res);

        Assert.assertTrue(res.size() == resultExpected.size());
        for (String item : resultExpected) {
            Assert.assertTrue(res.contains(item));
        }
    }

}
