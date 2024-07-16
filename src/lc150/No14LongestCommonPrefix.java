package lc150;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/longest-common-prefix/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No14LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        StringBuilder stringBuilder = new StringBuilder();
        int idx = 0;
        boolean flag = true;
        while (flag) {
            char c = ' ';
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() == 0) {
                    return stringBuilder.toString();
                }
                if (idx >= strs[i].length()) {
                    flag = false;
                    break;
                }
                if (c == ' ') {
                    c = strs[i].charAt(idx);
                }
                if (strs[i].charAt(idx) != c) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                stringBuilder.append(strs[0].charAt(idx));
            }
            idx++;
        }
        return stringBuilder.toString();
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println("1");
        System.out.println("abc".substring(0, 0));
        System.out.println("2");
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flag"}));
        System.out.println(longestCommonPrefix(new String[]{""}));

    }
}
