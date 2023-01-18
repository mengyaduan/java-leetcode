package Lc.backtrack;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/word-break-ii/?show=1">No140 单词拆分</a>
 **/
public class No140 {


    List<String> res = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        ArrayList<String> path = new ArrayList<>();
        backtrack(path, s, wordDict);

        return res;
    }

    public void backtrack(ArrayList<String> path, String s, List<String> dict) {
        // 回溯中止条件
        if (s == null || s.length() == 0) {
            String singlePath = String.join(" ", path);
            res.add(singlePath);
        }
        String tmp = "";
        for (int i = 0; i < s.length(); i++) {
            tmp += s.charAt(i);
            if (dict.contains(tmp)) {
                // 路径加入，从选择列表中剔除
                path.add(tmp);
                backtrack(path, s.substring(i + 1), dict);
                // 从路径中删除，加会选择列表
                int len = path.size();
                path.remove(len - 1);
            }
        }
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {"pineapplepenapple", new ArrayList<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")), new ArrayList<>(Arrays.asList("pine apple pen apple", "pineapple pen apple", "pine applepen apple"))},
                {"catsanddog", new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog")), new ArrayList<>(Arrays.asList("cats and dog", "cat sand dog"))},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, List<String> wordDict, List<String> resultExpected) {
        res.clear();
        wordBreak(s, wordDict);
        System.out.println(res);

        Assert.assertTrue(res.size() == resultExpected.size());
        for (String item : resultExpected) {
            Assert.assertTrue(res.contains(item));
        }
    }

    @Test(description = "")
    public void test2() throws Exception {
        String s = "catsanddog";
        List<String> dict = new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        wordBreak(s, dict);
        System.out.println(res);

    }

    @Test(description = "")
    public void testlkajf() throws Exception {
        String x = "123";
        System.out.println(x.substring(4));

    }
}
