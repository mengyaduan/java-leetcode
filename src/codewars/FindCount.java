package codewars;

import org.testng.annotations.Test;

public class FindCount {
    // TODO: 2021/12/6 递归

    /**
     * 题目：
     * 给定一个正整数 n ，你可以做如下操作：
     * 如果 n 是偶数，则用 n / 2替换 n 。
     * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
     * n 变为 1 所需的最小替换次数是多少
     * 输入：n = 8
     * 输出：3
     * 解释：8 -> 4 -> 2 -> 1
     * 输入：n = 7
     * 输出：4
     * 解释：7 -> 8 -> 4 -> 2 -> 1
     * 或 7 -> 6 -> 3 -> 2 -> 1
     **/
    public int count(int n) {
        int count = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                int a = getPriority(n + 1);
                int b = getPriority(n - 1);
                n = a > b ? n + 1 : n - 1;
            }
            count++;
            System.out.println(String.format("第%d步：num=%d", count, n));
        }
        return count;
    }

    public int getPriority(int num) {
        // 第一层判断奇偶
        int first = num % 2;
        // 如果第一层是奇数，不需要判定，直接返回
        if (first == 1) {
            return 2;
        } else {
            // 如果第一层是偶数，判定第二层
            int second = (num / 2) % 2;
            if (second == 0) {
                return 4;
            } else {
                return 3;
            }
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        int x = count(15);
        System.out.println(x);
    }


}
