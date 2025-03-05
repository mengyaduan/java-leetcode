package lc150;

import org.testng.annotations.Test;

import java.beans.PropertyEditorSupport;
import java.sql.PreparedStatement;
import java.util.Stack;

public class No224Calculate {


    public int calculate(String s) {
        int result = 0;
        Stack<Character> helper = new Stack<>();
        helper.add('(');
        int cur = 0;
        while (!helper.isEmpty()) {
            if (cur == s.length() || s.charAt(cur) == ')') {
                // 如果是右括号，或者已经到结尾了，需要触发一次计算
                Stack<Integer> numbers = new Stack<>();
                Stack<Character> signs = new Stack<>();
                int flag = 1;
                int number = 0;
                while (true) {
                    char item = helper.pop();
                    if (item == '(') {
                        numbers.add(number);
                        break;
                    }
                    if (item == '+' || item == '-') {
                        signs.add(item);
                        numbers.add(number);
                        flag = 1;
                        number = 0;
                    } else {
                        number += (item - '0') * flag;
                        flag *= 10;
                    }
                }
                result = cal(numbers, signs);
                if (!helper.isEmpty()) {
                    // 如果还有其他数据需要算，将结果重新录入到helper，cur++
                    char[] resStr = String.valueOf(result).toCharArray();
                    if (resStr[0] == '-') {
                        // 特殊情况 1 - （1-3），计算完1-3后，录入时需要判断栈顶符号
                        if (helper.peek() == '+') {
                            helper.pop();
                        } else if (helper.peek() == '-') {
                            helper.pop();
                            resStr[0] = '+';
                        }
                    }
                    for (char c : resStr) {
                        helper.add(c);
                    }
                }
            } else if (s.charAt(cur) != ')' && s.charAt(cur) != ' ') {
                helper.add(s.charAt(cur));
            }
            cur++;
        }
        return result;
    }

    private int cal(Stack<Integer> numbers, Stack<Character> signs) {
        int result = numbers.pop();
        while (!numbers.isEmpty()) {
            if (signs.pop() == '+') {
                result += numbers.pop();
            } else {
                result -= numbers.pop();
            }
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(calculate("1-(-2)"));

    }

}
