package Lc;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/queue-reconstruction-by-height/"</a>
 **/
public class No406 {

    public int[][] reconstructQueue(int[][] people) {
        int len = people.length;
        if (len <= 1) {
            return people;
        }
        // 按照第一位降序，第二位升序
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return b[0] - a[0];
            }
        });

        for (int[] person : people) {
            System.out.print("(" + person[0] + "," + person[1] + ")");
        }
        System.out.println();
        System.out.println("=====");

        ArrayList<int[]> temp = new ArrayList<>();
        for (int[] person : people) {
            temp.add(person[1], person);
        }

        for (int[] person : temp) {
            System.out.print("(" + person[0] + "," + person[1] + ")");

        }

        int[][] res = new int[len][];
        for (int i = 0; i < len; i++) {
            res[i] = temp.get(i);
        }
        return res;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[][]{{4, 0}, {5, 0}, {6, 0}, {2, 2}, {3, 2}, {1, 4}},
                        new int[][]{{4, 0}, {5, 0}, {2, 2}, {3, 2}, {1, 4}, {6, 0}}},
                {new int[][]{{4, 0}},
                        new int[][]{{4, 0}}},
                {new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}},
                        new int[][]{{5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}}
                },
                {new int[][]{{9, 0}, {7, 0}, {1, 9}, {3, 0}, {2, 7}, {5, 3}, {6, 0}, {3, 4}, {6, 2}, {5, 2}},
                        new int[][]{{3, 0}, {6, 0}, {7, 0}, {5, 2}, {3, 4}, {5, 3}, {6, 2}, {2, 7}, {9, 0}, {1, 9}}}

        };
        return data;
    }


    @Test(description = "单测", dataProvider = "cases")
    public void test(int[][] points, int[][] res) throws Exception {
        int[][] result = reconstructQueue(points);
        for (int i = 0; i < points.length; i++) {
            Assert.assertEquals(result[i], res[i]);
        }
    }

}
