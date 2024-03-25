package LcSecond.linkedList;

import DataStruct.ListNode;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * @see <a href="https://leetcode.com/problems/linked-list-components/description/">链表组件</a>
 **/
public class No817_LinkedListComponents {
    public int numComponents(ListNode head, int[] nums) {
        // 把nums转成包含contains方法的
        HashMap<Integer, Boolean> used = new HashMap<>();
        ArrayList<Integer> helper = Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
        int res = 0;
        ListNode cur = head;
        while (cur != null) {
            if (helper.contains(cur.val) && !used.containsKey(cur.val)) {
                // 将用过的数字置为true
                used.put(cur.val, true);
                cur = cur.next;
                while (cur != null && helper.contains(cur.val)) {
                    used.put(cur.val, true);
                    cur = cur.next;
                }
                res++;
            } else {
                cur = cur.next;
            }
        }
        return res;
    }


    @Test(description = "")
    public void test2() throws Exception {
        ListNode head = ListNode.createListNode(0, 1, 2, 3, 4);
        int[] nums = new int[]{0, 4, 1, 3};
        System.out.println(numComponents(head, nums));
    }

    @Test(description = "")
    public void test() throws Exception {
        ListNode head = ListNode.createListNode(0, 1, 2, 3);
        int[] nums = new int[]{0, 1, 3};
        System.out.println(numComponents(head, nums));
    }

}
