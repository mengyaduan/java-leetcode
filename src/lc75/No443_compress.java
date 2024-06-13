package lc75;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/string-compression/description/?envType=study-plan-v2&envId=leetcode-75">压缩字符串</a>
 */
public class No443_compress {
    public int compress(char[] chars) {
        int cur = 0;
        StringBuilder s = new StringBuilder();
        while (cur < chars.length) {
            char nowAt = chars[cur];
            int count = 1;
            while (cur + 1 < chars.length && chars[cur + 1] == nowAt) {
                cur++;
                count++;
            }
            if (count == 1) {
                s.append(nowAt);
            } else {
                s.append(nowAt).append(count);
            }
            cur++;
        }
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
//        System.out.println(chars);
        return s.length();
    }


    @Test(description = "")
    public void test() throws Exception {
        String a = "aabbbbbbbbbbsscc";
        char[] x = a.toCharArray();
        System.out.println(compress(x));

    }
}
