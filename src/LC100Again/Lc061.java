package LC100Again;


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Lc061 {


    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        int[][] memo = new int[s.length()][s.length()];
        char[] sc = s.toCharArray();
        backtrack(sc, 0, new ArrayList<>(), result, memo);
        return result;
    }

    private void backtrack(char[] sc, int start, ArrayList<String> path, List<List<String>> result, int[][] memo) {
        if (start == sc.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < sc.length; i++) {
            if (isPalindrome(sc, start, i, memo)) {
                path.add(new String(sc, start, i - start + 1));
                backtrack(sc, i + 1, path, result, memo);
                path.remove(path.size() - 1);
            }
        }
    }

    boolean isPalindrome(char[] sc, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) {
            return memo[i][j] == 1;
        }
        while (i < j) {
            if (sc[i] != sc[j]) {
                memo[i][j] = 2;
                return false;
            }
            i++;
            j--;
        }
        memo[i][j] = 1;
        return true;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(partition("aab"));
        System.out.println(partition("b"));
        System.out.println(partition("acbab"));


    }


}
