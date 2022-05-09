package Lc.string;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/palindrome-partitioning/">No131 分割回文串</a>
 **/
public class No131 {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int len = s.length();
        int[][] memo = new int[len][len];
        List<String> tmp = new ArrayList<>();
        dfs(tmp, res, memo, 0, s);
        return res;
    }

    public void dfs(List<String> tmp, List<List<String>> res, int[][] memo, int start, String s) {
        if (start == s.length()) {
            List<String> x = new ArrayList<>();
            for (String m : tmp) {
                x.add(m);
            }
            res.add(x);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (memo[start][i] == 1 || isPalindrome(s, start, i, memo)) {
                tmp.add(s.substring(start, i + 1));
                dfs(tmp, res, memo, i + 1, s);
                tmp.remove(tmp.size() - 1);
            }
        }
    }


    public boolean isPalindrome(String s, int l, int r, int[][] memo) {
        if (s.length() == 1) {
            memo[l][r] = 1;
            return true;
        }
        int left = l;
        int right = r;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                memo[l][r] = 2;
                return false;
            }
            left++;
            right--;
        }
        memo[l][r] = 1;
        return true;
    }


    @DataProvider(name = "unit")
    public Object[][] unit() {
        Object[][] data = {
                //
                {"aab"},
                {"ab"},
                {"efe"},
                {"abbc"},
                {"aabbc"},
        };
        return data;
    }


    @Test(description = "", dataProvider = "unit")
    public void testUnit(String s) throws Exception {
        System.out.println("s=" + s);
        List<List<String>> x = partition(s);
        for (int i = 0; i < x.size(); i++) {
            System.out.println(x.get(i));
        }
        System.out.println("=========================");
    }

    @Test(description = "")
    public void test() throws Exception {
        List<String> x = new ArrayList<>();
        x.add("1");
        x.add("2");
        x.add("3");
        x.add("4");
        x.add("5");
        System.out.println(x.size());
        System.out.println(x.subList(0, 4));
        System.out.println(x.size());
        System.out.println(x);
        x = x.subList(0, 3);
        System.out.println(x.size());
        System.out.println(x);
        x = x.subList(0, 2);
        System.out.println(x.size());
        System.out.println(x);

    }
}
