package lc75;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @see <a href="https://leetcode.cn/problems/daily-temperatures/description/?envType=study-plan-v2&envId=leetcode-75">每日温度</a>
 */
public class No739_dailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        if (temperatures.length == 1) {
            return res;
        }
        element[] t = new element[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            t[i] = new element(i, temperatures[i]);
        }
        Stack<element> helper = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            element elementNow = t[i];
            int now = t[i].temperature;
            if (helper.isEmpty()) {
                helper.push(elementNow);
                res[i] = 0;
                continue;
            }
            if (now < helper.peek().temperature) {
                // 前一天是低温，则直接入栈
                helper.push(elementNow);
                res[i] = 1;
            } else {
                // 如果栈顶的温度比当天低，那么弹出，直到栈空或者栈顶大于now
                int distance = 0;
                while (!helper.isEmpty() && now >= helper.peek().temperature) {
                    element out = helper.pop();
                    distance += res[out.index];
                }
                if (helper.isEmpty()) {
                    res[i] = 0;
                } else {
                    res[i] = distance + 1;
                }
                helper.push(elementNow);
            }
        }

        return res;
    }

    class element {
        int index;
        int temperature;

        element(int idx, int temperature) {
            this.index = idx;
            this.temperature = temperature;
        }
    }

    @Test(description = "")
    public void test() throws Exception {
//        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] temperatures = new int[]{30, 40, 50, 60};
        int[] x = dailyTemperatures(temperatures);
        System.out.println(StringUtils.join(Arrays.stream(x).mapToObj(String::valueOf).toArray(), ","));
    }
}
