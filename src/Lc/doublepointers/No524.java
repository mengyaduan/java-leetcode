package Lc.doublepointers;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/"</a>
 **/
public class No524 {

    /**
     * 解题思路：
     * 1. 取dict中的item
     * 2. 指针1指向s开头，指针2指向item开头，如果在指针1遍历完s时，指针2还没有遍历完item，则该项不符合要求，取下一个item
     * 3. 如果可以遍历完成，与已有结果比大小，留下size大的那个，如果一样大，按照字典顺序返回
     **/

    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";
        int lenS = s.length();
        for (String item : dictionary) {
            int l = 0, r = 0;
            while (l < lenS) {
                if (s.charAt(l) == item.charAt(r)) {
                    r++;
                }
                l++;
                if (r == item.length()) {
                    if (item.length() > result.length()) {
                        result = item;
                    } else if (item.length() == result.length()) {
                        result = result.compareTo(item) < 0 ? result : item;
                    }
                    break;
                }
            }
        }
        return result;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {"abpcplea", Arrays.asList("ale", "apple", "monkey", "plea"), "apple"},
                {"abpcplea", Arrays.asList("a", "b", "c", "p"), "a"},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, List<String> dict, String result) {
        String res = findLongestWord(s, dict);
        Assert.assertEquals(res, result);
    }

}
