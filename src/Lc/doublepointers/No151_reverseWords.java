package Lc.doublepointers;


import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/reverse-words-in-a-string/description/">翻转字符串</a>
 **/
public class No151_reverseWords {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        int start = findStart(s, s.length() - 1);
        while (start >= 0) {
            StringBuilder singleworld = new StringBuilder();
            while (start >= 0 && s.charAt(start) != ' ') {
                singleworld.insert(0, s.charAt(start));
                start--;
            }
            res.append(singleworld);
            res.append(" ");
            start = findStart(s, start);
        }
        return res.substring(0, res.length() - 1);
    }

    public int findStart(String s, int last) {
        while (last >= 0 && s.charAt(last) == ' ') {
            last--;
        }
        return last;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("a good   example"));

    }

}
