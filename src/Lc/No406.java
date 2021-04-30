package Lc;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/queue-reconstruction-by-height/"</a>
 **/
public class No406 {

    class Node {
        int h;
        int k;
        Node pre;
        Node next;

        Node(int h, int k) {
            this.h = h;
            this.k = k;
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        int len = people.length;
        if (len <= 1) {
            return people;
        }
        // 根据第二个升序，根据第一个降序
        Arrays.sort(people, (a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            } else {
                return a[1] - b[1];
            }
        });

        Node head = new Node(people[0][0], people[0][1]);


        for (int i = 1; i < len; i++) {
            Node now = new Node(people[i][0], people[i][1]);
            Node finder = head;
            int counter = 0;
            while (finder != null) {
                if (counter >= now.k) {
                    break;
                }
                if (finder.h >= now.h) {
                    counter++;
                }
                finder = finder.next;
            }
            // 在当前finder位置之前插入节点。
            if (finder.pre == null) {
                now.next = finder;
            } else {
                finder.pre.next = now;
                now.next = finder;
            }
            head = now;

            System.out.println("he");

        }
        System.out.println("he");


        return null;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                //
                {new int[][]{{4, 0}, {5, 0}, {6, 0}, {2, 2}, {3, 2}, {1, 4}}, new int[][]{{1, 2}}},
//                {new int[][]{{6, 0}, {5, 0}, {4, 0}, {1, 4}, {3, 2}, {2, 2}}, new int[][]{{1, 2}}},
        };
        return data;
    }


    @Test(description = "单测", dataProvider = "cases")
    public void test(int[][] points, int[][] res) throws Exception {
        int[][] result = reconstructQueue(points);
        Assert.assertEquals(res, result, "预期输出：" + res + "\n实际输出:" + result);
    }

}
