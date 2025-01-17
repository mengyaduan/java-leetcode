package LcSpring100;

import org.testng.annotations.Test;

import java.util.*;

public class No316RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> helper = new HashMap<>();
        // 先记录每个字符最后出现的位置
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            helper.put(item, i);
        }
        HashSet<Character> used = new HashSet<>();

        // 利用辅助栈来去重
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            // 如果是空栈，直接如
            if (deque.isEmpty()) {
                deque.addLast(item);
                used.add(item);
            } else {
                // 和栈顶比较，如果小于栈顶，然后栈顶的最后一次出现位置比当前大，则弹出并追加
                while ((!deque.isEmpty() && item < deque.peekLast() && helper.get(deque.peekLast()) > i) && !used.contains(item)) {
                    used.remove(deque.peekLast());
                    deque.pollLast();
                }
                if (!used.contains(item)) {
                    deque.addLast(item);
                    used.add(item);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        while (!deque.isEmpty()) {
            result.append(deque.pollFirst());
        }
        return result.toString();
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(removeDuplicateLetters("abacb"));
        System.out.println(removeDuplicateLetters("cbacdcbc"));

    }
}
