package lc75;

import org.testng.annotations.Test;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.cn/problems/online-stock-span/description/?envType=study-plan-v2&envId=leetcode-75">股票价格跨度</a>
 */
public class StockSpanner {
    Stack<Integer[]> stock;

    public StockSpanner() {
        stock = new Stack<>();
    }

    public int next(int price) {
        Integer[] item = new Integer[]{price, 1};
        if (stock.isEmpty()) {
            stock.push(item);
            return item[1];
        }
        while (!stock.isEmpty() && item[0] >= stock.peek()[0]) {
            // 如果price大于等于栈顶，则弹出，并++
            item[1] += stock.pop()[1];
        }
        stock.push(item);
        return item[1];
    }


    @Test(description = "")
    public void test2() throws Exception {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(29));
        System.out.println(stockSpanner.next(91));
        System.out.println(stockSpanner.next(62));
        System.out.println(stockSpanner.next(76));
        System.out.println(stockSpanner.next(51));
    }

    @Test(description = "")
    public void test() throws Exception {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(32));
        System.out.println(stockSpanner.next(82));
        System.out.println(stockSpanner.next(73));
        System.out.println(stockSpanner.next(99));
        System.out.println(stockSpanner.next(91));
    }
}
