package Lc.doublepointers;

import DataStruct.ListNode;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/add-two-numbers/description/">两数和</a>
 **/
public class No2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode head = result;
        int flag = 0;
        while (flag != 0 || l1 != null || l2 != null) {
            int i = l1 == null ? 0 : l1.val;
            int j = l2 == null ? 0 : l2.val;
            int res = i + j + flag;
            ListNode item = new ListNode();
            item.val = res >= 10 ? res % 10 : res;
            flag = res >= 10 ? 1 : 0;
            head.next = item;
            head = head.next;
            // 计算结束，l1和l2得前进
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return result.next;
    }


    @DataProvider(name = "unit")
    public Object[][] unit() {
        return new Object[][]{
                {new int[]{2, 4, 3}, new int[]{5, 6, 4}, "7 → 0 → 8"},
                {new int[]{2, 4, 3}, new int[]{0}, "2 → 4 → 3"},
                {new int[]{0}, new int[]{0}, "0"},
                {new int[]{9, 9, 9}, new int[]{9, 9, 9, 9}, "8 → 9 → 9 → 0 → 1"},
        };
    }

    @Test(description = "", dataProvider = "unit")
    public void test(int[] l1n, int[] l2n, String res) throws Exception {
        ListNode l1 = ListNode.createListNode(l1n);
        ListNode l2 = ListNode.createListNode(l2n);
        Assert.assertEquals(addTwoNumbers(l1, l2).toString(), res);

    }
}

