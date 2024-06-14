package lc75;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/?envType=study-plan-v2&envId=leetcode-75">定长子串中元音的最大数目</a>
 */
public class No1456_maxVowels {

    public int maxVowels(String s, int k) {
        int sum = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < k; i++) {
            if (vowelCheck(cs[i])) {
                sum++;
            }
        }
        int res = sum;
        int left = 0;
        for (int i = k; i < cs.length; i++) {
            // 扩展右边界
            if (vowelCheck(cs[i])) {
                sum++;
            }
            // 收缩左边界
            if (vowelCheck(cs[left])) {
                sum--;
            }
            left++;
            // 更新最大值
            res = Math.max(res, sum);
        }
        return res;
    }

    public boolean vowelCheck(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(maxVowels("abciiidef", 3));
        System.out.println(maxVowels("aeiou", 2));
        System.out.println(maxVowels("gkhjlgk", 2));

    }
}
