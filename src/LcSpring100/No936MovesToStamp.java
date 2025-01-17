package LcSpring100;

import org.testng.annotations.Test;

import java.util.Stack;

import static DataStruct.tools.printIntArray;

public class No936MovesToStamp {


    public int[] movesToStamp(String stamp, String target) {
        int size = stamp.length();
        char[] targetC = target.toCharArray();
        char[] stampC = stamp.toCharArray();
        // 闭区间
        Stack<Integer> res = new Stack<>();
        int l = 0, r = size - 1;
        while (r < target.length()) {
            boolean isMatch = match(stampC, targetC, l, r);
            if (isMatch) {
                res.add(l);
                if (res.size() > 10 * target.length()) {
                    return new int[0];
                }
                for (int i = l; i <= r; i++) {
                    targetC[i] = '?';
                }
                l = Math.max(l - size + 1, 0);
                r = l + size - 1;
            } else {
                l++;
                r++;
            }
        }

        // 检查是否全部变成问号
        for (char c : targetC) {
            if (c != '?') {
                return new int[0];
            }
        }
        int[] result = new int[res.size()];
        int i = 0;
        while (!res.isEmpty()) {
            result[i] = res.pop();
            i++;
        }
        return result;
    }

    private boolean match(char[] stamp, char[] target, int l, int r) {
        int count = 0;
        for (int i = l; i <= r; i++) {
            if (target[i] == '?') {
                count++;
            }
            if (target[i] != '?' && stamp[i - l] != target[i]) {
                return false;
            }
        }
        return count == r - l + 1 ? false : true;
    }

    @Test(description = "")
    public void test() throws Exception {
        printIntArray(movesToStamp("abca", "aabcaca"));
        printIntArray(movesToStamp("abc", "ababc"));
    }

}
