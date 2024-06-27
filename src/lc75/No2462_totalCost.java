package lc75;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import javax.swing.plaf.IconUIResource;
import javax.xml.stream.events.ProcessingInstruction;
import java.util.*;

/**
 * @see <a href="https://leetcode.cn/problems/total-cost-to-hire-k-workers/description/?envType=study-plan-v2&envId=leetcode-75">雇佣K位工人的总代价</a>
 */
public class No2462_totalCost {
    ArrayList<Integer> tmp = new ArrayList<>();

    public long totalCost(int[] costs, int k, int candidates) {
        long res = 0;
        int n = costs.length;
        int[] picked = new int[n + 1];
        PriorityQueue<Integer> pqLeft = new PriorityQueue<>((a, b) -> {
            if (costs[a] - costs[b] != 0) {
                return costs[a] - costs[b];
            } else {
                return a - b;
            }
        });
        PriorityQueue<Integer> pqRight = new PriorityQueue<>((a, b) -> {
            if (costs[a] - costs[b] != 0) {
                return costs[a] - costs[b];
            } else {
                return a - b;
            }
        });
        int leftCur = 0;
        int rightCur = n - 1;
        while (k > 0) {
            while (leftCur < n && pqLeft.size() < candidates) {
                if (picked[leftCur] != 1) {
                    pqLeft.offer(leftCur);
                }
                leftCur++;
            }
            while (rightCur >= 0 && pqRight.size() < candidates) {
                if (picked[rightCur] != 1) {
                    pqRight.offer(rightCur);
                }
                rightCur--;
            }
            if (pqLeft.isEmpty() || pqRight.isEmpty()) {
                break;
            }
            // 比较左右
            int idx;
            if (costs[pqLeft.peek()] == costs[pqRight.peek()]) {
                // 如果最小值相等，那么就需要比较坐标值
                if (pqLeft.peek().intValue() < pqRight.peek().intValue()) {
                    idx = pqLeft.poll();
                } else if (pqLeft.peek().intValue() > pqRight.peek().intValue()) {
                    idx = pqRight.poll();
                } else {
                    idx = pqLeft.poll();
                    pqRight.poll();
                }
            } else {
                // 如果值不等，那么pop出小的那个就可以了
                if (costs[pqLeft.peek()] > costs[pqRight.peek()]) {
                    idx = pqRight.poll();
                } else {
                    idx = pqLeft.poll();
                }
            }
            tmp.add(costs[idx]);
            res += costs[idx];
            picked[idx] = 1;
            k--;
        }
        return res;
    }

    @Test(description = "")
    public void test3() throws Exception {
        int[] costs = new int[]{69, 10, 63, 24, 1, 71, 55, 46, 4, 61, 78, 21, 85, 52, 83, 77, 42, 21, 73, 2, 80, 99, 98, 89, 55, 94, 63, 50, 43, 62, 14};
        System.out.println(totalCost(costs, 21, 31));

        System.out.println(StringUtils.join(tmp, ","));
        Arrays.sort(costs);
        System.out.println(StringUtils.join(Arrays.stream(costs).mapToObj(String::valueOf).toArray(), ","));

    }

    @Test(description = "")
    public void test2() throws Exception {
        int[] costs = new int[]{31, 25, 72, 79, 74, 65, 84, 91, 18, 59, 27, 9, 81, 33, 17, 58};
        System.out.println(totalCost(costs, 11, 2));
    }

    @Test(description = "")
    public void test1() throws Exception {
        int[] costs = new int[]{1, 2, 4, 1};
        System.out.println(totalCost(costs, 3, 3));
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] costs = new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8};
        System.out.println(totalCost(costs, 3, 4));
    }

    @Test(description = "")
    public void test123() throws Exception {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.offer(3);
        pq.offer(1);
        pq.offer(2);
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());

    }
}
