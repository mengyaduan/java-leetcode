package lc150;

import java.util.HashMap;
import java.util.Stack;

/**
 * @see <a href="https://leetcode.cn/problems/valid-parentheses/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No20IsValid {

    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> helper = new Stack<>();
        char[] cs = s.toCharArray();
        int i = 0;
        while (i < cs.length) {
            char item = cs[i];
            if (item == '(' || item == '{' || item == '[') {
                // 如果是左括号，直接入栈
                helper.push(item);
            } else {
                if (helper.isEmpty()) {
                    return false;
                }
                // 弹出栈顶
                char top = helper.pop();
                // 栈顶不匹配
                if (map.get(item) != top) {
                    return false;
                }
            }
            i++;
        }
        return helper.isEmpty();
    }

}
