package LcSpring100;

import java.util.Stack;

public class No20IsBracketValid {

    public boolean isValid(String s) {
        Stack<Character> helper = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (item == '(' || item == '{' || item == '[') {
                helper.push(item);
            } else {
                if (helper.isEmpty()) {
                    return false;
                }
                boolean res = false;
                char pop = helper.pop();
                res |= pop == '(' && item == ')';
                res |= pop == '[' && item == ']';
                res |= pop == '{' && item == '}';
                if (!res) {
                    return false;
                }
            }
        }
        return helper.isEmpty();
    }

}
