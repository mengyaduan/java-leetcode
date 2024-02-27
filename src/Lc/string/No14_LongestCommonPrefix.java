package Lc.string;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/longest-common-prefix/description/">最长公共前缀</a>
 **/
public class No14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            boolean flag = false;
            char c = 0;
            for (String item : strs) {
                if (i > item.length() - 1) {
                    flag = true;
                    break;
                }
                if (c == 0) {
                    c = item.charAt(i);
                } else {
                    if (item.charAt(i) != c) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) {
                break;
            }
            sb.append(c);
            i++;
        }
        return sb.toString();
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(longestCommonPrefix(new String[]{"flow", "flower", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"abc", "efg", "xxx"}));

    }

}

