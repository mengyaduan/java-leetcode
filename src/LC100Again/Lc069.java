package LC100Again;


import java.util.Stack;

public class Lc069 {

    public boolean isValid(String s) {
        Stack<Character> helper = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                helper.push(c);
            } else if (c == ')' && !helper.empty() && helper.peek() == '(') {
                helper.pop();
            } else if (c == '}' && !helper.empty() && helper.peek() == '{') {
                helper.pop();
            } else if (c == ']' && !helper.empty() && helper.peek() == '[') {
                helper.pop();
            } else {
                return false;
            }
        }
        return helper.isEmpty();
    }


}
