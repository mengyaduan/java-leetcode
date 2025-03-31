package Lc119;

import java.util.ArrayDeque;
import java.util.Deque;

public class LCR037 {

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> helper = new ArrayDeque<>();
        for (int item : asteroids) {
            if (helper.isEmpty() || item * helper.peekLast() > 0) {
                // 如果没有数据或者同向
                helper.addLast(item);
            } else {
                if (helper.peekLast() < 0 && item > 0) {
                    // 左右
                    helper.addLast(item);
                    continue;
                }
                if (helper.peekLast() > 0 && item < 0) {
                    // 相向且会碰撞，需要考虑大小问题
                    if (helper.peekLast() == -item) {
                        // 相向且质量一样，则一起爆炸
                        helper.pollLast();
                        continue;
                    }
                    if (helper.peekLast() > -item) {
                        // 相向，但没有栈里面大，则不处理
                        continue;
                    }
                    // 相向，但比栈里面大，
                    while (!helper.isEmpty() && (helper.peekLast() > 0 && helper.peekLast() < -item)) {
                        helper.pollLast();
                    }
                    if (helper.isEmpty() || helper.peekLast() < 0) {
                        // 空栈 或者 栈顶也是小于0的，则直接追加即可
                        helper.addLast(item);
                    } else if (helper.peekLast() == -item) {
                        // 栈顶是正数，大小和item一致，对撞摧毁
                        helper.pollLast();
                    }
                }
            }
        }
        return helper.stream().mapToInt(Integer::intValue).toArray();
    }

}
