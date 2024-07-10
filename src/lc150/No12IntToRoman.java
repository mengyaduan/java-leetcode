package lc150;

import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.cn/problems/integer-to-roman/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No12IntToRoman {

    public String intToRoman(int num) {
        HashMap<Integer, String> roman = new HashMap<>();
        roman.put(1000, "M");
        roman.put(900, "CM");
        roman.put(500, "D");
        roman.put(400, "CD");
        roman.put(100, "C");
        roman.put(90, "XC");
        roman.put(50, "L");
        roman.put(40, "XL");
        roman.put(10, "X");
        roman.put(9, "IX");
        roman.put(5, "V");
        roman.put(4, "IV");
        roman.put(1, "I");

        int[] list = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (num > 0) {
            int item = list[i];
            if (num >= item) {
                for (int j = 0; j < num / item; j++) {
                    stringBuilder.append(roman.get(item));
                }
                num %= item;
            }
            i++;
        }
        return stringBuilder.toString();
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(intToRoman(3749));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));

    }
}
