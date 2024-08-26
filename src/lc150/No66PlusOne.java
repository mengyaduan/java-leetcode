package lc150;

import java.util.ArrayList;

/**
 * @see <a href="https://leetcode.cn/problems/plus-one/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No66PlusOne {

    public int[] plusOne(int[] digits) {
        ArrayList<Integer> res = new ArrayList<>();
        int flag = 1;
        int i = digits.length - 1;
        while (flag == 1 || i >= 0) {
            int x = 0;
            if (i >= 0) {
                x = digits[i];
            }
            int item = x + flag;
            flag = item / 10;
            item = item % 10;
            res.add(0, item);
            i--;
        }
        int[] result = res.stream().mapToInt(Integer::valueOf).toArray();
        return result;
    }

}
