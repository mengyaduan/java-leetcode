package lc100;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No131 {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s.isEmpty()) {
            return new ArrayList<>();
        }
        if (s.length() == 1) {
            result.add(new ArrayList<>(Collections.singletonList(s)));
            return result;
        }
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (isPalindrome(c, 0, i)) {
                String pre = new String(c, 0, i + 1);
                List<List<String>> rightSide = partition(s.substring(i + 1));
                if (rightSide.isEmpty()) {
                    ArrayList<String> item = new ArrayList<>();
                    item.add(pre);
                    result.add(item);
                }
                for (List<String> strings : rightSide) {
                    ArrayList<String> item = new ArrayList<>();
                    item.add(pre);
                    item.addAll(strings);
                    result.add(item);
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(char[] c, int i, int j) {
        while (i < j) {
            if (c[i] == c[j]) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(partition("aa"));
        System.out.println(partition("aab"));
        System.out.println(partition("aacbb"));

    }

}
