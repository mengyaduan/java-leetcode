package Lc119;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCR086 {

    public String[][] partition(String s) {
        ArrayList<ArrayList<String>> result = partition2(s);
        String[][] res = new String[result.size()][s.length()];
        for (int i = 0; i < res.length; i++) {
            int itemSize = result.get(i).size();
            res[i] = new String[itemSize];
            for (int j = 0; j < itemSize; j++) {
                res[i][j] = result.get(i).get(j);
            }
        }
        return res;
    }

    public ArrayList<ArrayList<String>> partition2(String s) {
        if (s.length() == 1) {
            ArrayList<ArrayList<String>> m = new ArrayList<>();
            m.add(new ArrayList<>(Arrays.asList(s)));
            return m;
        }
        if (s.length() == 0) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (int j = 1; j < s.length() + 1; j++) {
            String prefix = s.substring(0, j);
            if (palindrome(prefix)) {
                ArrayList<ArrayList<String>> temp = partition2(s.substring(j));
                if (temp.size() == 0) {
                    result.add(new ArrayList<>(Arrays.asList(prefix)));
                } else {
                    for (ArrayList<String> item : temp) {
                        item.add(0, prefix);
                        result.add(item);
                    }
                }
            }
        }
        return result;
    }

    private boolean palindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
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
        ArrayList<ArrayList<String>> x = partition2("bb");
        System.out.println(x);
        String[][] y = partition("bb");
        System.out.println();
    }

}
