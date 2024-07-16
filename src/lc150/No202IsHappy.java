package lc150;

import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.cn/problems/happy-number/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No202IsHappy {

    public boolean isHappy(int n) {
        HashMap<Integer, Integer> helper = new HashMap<>();
        while (true) {
            if (n == 1) {
                return true;
            }
            n = cal(n);
            if (helper.containsKey(n)) {
                return false;
            } else {
                helper.put(n, 1);
            }
        }
    }

    public int cal(int n) {
        int res = 0;
        while (n > 0) {
            int mod = n % 10;
            res += mod * mod;
            n /= 10;
        }
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(isHappy(1));
        System.out.println(isHappy(2));
        System.out.println(isHappy(19));

    }
}
