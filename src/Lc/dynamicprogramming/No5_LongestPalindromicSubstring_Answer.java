package Lc.dynamicprogramming;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/longest-palindromic-substring/description/">最长回文子串（连续子串）</a>
 **/
public class No5_LongestPalindromicSubstring_Answer {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int maxStart = 0;
        int maxEnd = 0;
        int maxLen = 1;

        boolean[][] dpTable = new boolean[s.length()][s.length()];
        dpTable[0][0] = true;


        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                dpTable[i][j] = (j - i <= 2 || dpTable[i + 1][j - 1]) && s.charAt(i) == s.charAt(j);
                if (dpTable[i][j] && j - i + 1 > maxLen) {
                    maxStart = i;
                    maxEnd = j;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    /**
     * m[i,j] = m[i+1,j-1] && s.charAt(i)==s.charAt(j)
     **/


    @Test(description = "")
    public void test() throws Exception {
        System.out.println(longestPalindrome("bacabab"));
        System.out.println(longestPalindrome("abb"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("asdfdsa"));
        System.out.println(longestPalindrome("aacabdkacaa"));
//        System.out.println(longestPalindrome("xeeevvgrqunieginnvgvttbloinzpmoiaczszxswpmsxkhtnyrzimeckwndjnrvczcokshsachapcsbhijbbedfjnccqifibbumjchrarmvfoacdxwwkwrsnnebsdqksjmxzuwlpztltsgtllviztsqzzzzsrxkhmrugklfxinlkbdtgzaqgrrnplsbbtoqfrjwzqhwozesjqanifdswbtrkbtzkwtcodejwdorsdcairdodaluaafbviigevezrkovmcbswauhkvhrhzojdmlevuvfycjqntgpxtjtqqtjtxpgtnqjcyfvuvelmdjozhrhvkhuawsbcmvokrzevegiivbfaauladodriacdsrodwjedoctwkztbkrtbwsdfinaqjsezowhqzwjrfqotbbslpnrrgqazgtdbklnixflkgurmhkxrszzzzqstzivlltgstltzplwuzxmjskqdsbennsrwkwwxdcaofvmrarhcjmubbifiqccnjfdebbjihbscpahcashskoczcvrnjdnwkcemizrynthkxsmpwsxzszcaiompzniolbttvgvnnigeinuqrgvveeex"));

    }


}




