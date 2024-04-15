package LcSecond.simulation;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/time-needed-to-buy-tickets/description/?envType=daily-question&envId=2024-04-09">排队买票需要的最短时间</a>
 **/
public class No2073_TimeNeededToBuyTickets {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int count = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                count += Math.min(tickets[i], tickets[k]);
            } else {
                if (tickets[i] < tickets[k]) {
                    count += tickets[i];
                } else {
                    count += tickets[k] - 1;
                }
            }
        }
        return count;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] tickets = new int[]{5, 6, 8, 2};
        Assert.assertEquals(timeRequiredToBuy(tickets, 0), 15);
        Assert.assertEquals(timeRequiredToBuy(tickets, 1), 18);
        Assert.assertEquals(timeRequiredToBuy(tickets, 2), 21);
        Assert.assertEquals(timeRequiredToBuy(tickets, 3), 8);

    }
}
