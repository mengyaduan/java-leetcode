package lc150;

/**
 * @see <a href="https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No28StrStr {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int i = 0;
        while (i < haystack.length()) {
            int cur = i;
            int j = 0;
            while (cur < haystack.length() && j < needle.length()) {
                if (haystack.charAt(cur) != needle.charAt(j)) {
                    break;
                }
                cur++;
                j++;
            }
            if (j == needle.length()) {
                // 遍历完成
                return i;
            }
            i++;
        }
        return -1;
    }

}
