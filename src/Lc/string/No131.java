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
        List<List<String>> draft = doSplit(s);
        for (List<String> list : draft) {
            boolean flag = true;
            for (String item : list) {
                if (!isPalindrome(item)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(list);
            }
        }
        return res;
    }

    public List<List<String>> doSplit(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 1) {
            List<String> tmp = new ArrayList<>();
            tmp.add(s);
            res.add(tmp);
            return res;
        }
        List<List<String>> child = doSplit(s.substring(1));
        // 首先自己跟child隔离
        for (int i = 0; i < child.size(); i++) {
            List<String> father = new ArrayList<>();
            father.add(s.substring(0, 1));
            father.addAll(child.get(i));
            res.add(father);
        }
        // 拼装
        for (int i = 0; i < child.size(); i++) {
            String head = s.substring(0, 1);
            String tail = child.get(i).get(0);
            List<String> father = new ArrayList<>();
            father.add(head + tail);
            child.get(i).remove(0);
            father.addAll(child.get(i));
            res.add(father);
        }
        return res;
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    @DataProvider(name = "unit")
    public Object[][] unit() {
        Object[][] data = {
                //

                {"ab"},
                {"efe"},
                {"abbc"},
                {"aabbc"},
        };
        return data;
    }


    @Test(description = "", dataProvider = "unit")
    public void test(String s) throws Exception {
        System.out.println("s=" + s);
        List<List<String>> x = partition(s);
        for (int i = 0; i < x.size(); i++) {
            System.out.println(x.get(i));
        }
        System.out.println("=========================");
    }
}
