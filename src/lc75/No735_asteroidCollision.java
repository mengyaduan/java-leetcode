package lc75;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

/**
 * @see <a href="https://leetcode.cn/problems/asteroid-collision/description/?envType=study-plan-v2&envId=leetcode-75">小行星碰撞</a>
 */
public class No735_asteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> helper = new Stack<>();
        int i = 0;
        while (i < asteroids.length) {
            if (helper.isEmpty() || helper.peek() * asteroids[i] > 0) {
                // 如果是同向的，直接push
                helper.push(asteroids[i]);
                i++;
            } else {
                // 如果是相向的，需要比较大小
                // 如果in<0,out>0,直接++就行了
                if (helper.peek() < 0) {
                    helper.push(asteroids[i]);
                    i++;
                    continue;
                }
                int in = Math.abs(helper.peek());
                int out = Math.abs(asteroids[i]);
                if (in > out) {
                    i++;
                } else if (in < out) {
                    helper.pop();
                } else {
                    // in == out
                    helper.pop();
                    i++;
                }
            }
        }
        int len = helper.size();
        int[] res = new int[len];
        int j = len - 1;
        while (!helper.isEmpty()) {
            res[j] = helper.pop();
            j--;
        }
        return res;
    }

    @DataProvider(name = "unit")
    public Object[][] unit() {
        return new Object[][]{
                {new int[]{-2, -1, 1, 2}},
//                {new int[]{5, 10, -5}},
//                {new int[]{8, -8}},
//                {new int[]{10, 2, -5}},
        };
    }

    @Test(description = "", dataProvider = "unit")
    public void test(int[] asteroids) throws Exception {
        int[] res = asteroidCollision(asteroids);
        System.out.println(StringUtils.join(Arrays.stream(res).mapToObj(String::valueOf).toArray(String[]::new), ","));

    }
}
