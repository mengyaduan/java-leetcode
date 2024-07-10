package lc150;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.cn/problems/roman-to-integer/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No13RomanToInt {

    public int romanToInt(String s) {
        HashMap<String, Integer> roman = new HashMap<>();
        roman.put("I", 1);
        roman.put("IV", 4);
        roman.put("V", 5);
        roman.put("IX", 9);
        roman.put("X", 10);
        roman.put("XL", 40);
        roman.put("L", 50);
        roman.put("XC", 90);
        roman.put("C", 100);
        roman.put("CD", 400);
        roman.put("D", 500);
        roman.put("CM", 900);
        roman.put("M", 1000);

        int result = 0;
        int i = 0;
        while (i < s.length()) {
            if (i + 1 < s.length() && roman.containsKey(s.substring(i, i + 2))) {
                result += roman.get(s.substring(i, i + 2));
                i += 2;
            } else {
                result += roman.get(s.substring(i, i + 1));
                i++;
            }
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(romanToInt("MCMXCIV"));
    }


}
