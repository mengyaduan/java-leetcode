package LcSecond.binarySearch;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import javax.swing.text.html.parser.Entity;
import java.util.*;

/**
 * @see <a href="https://leetcode.com/problems/random-pick-with-weight/description/">根据权重随机返回坐标</a>
 */
public class No528_RandomIndex {


    HashMap<Integer, Integer> memo = new HashMap<>();
    int n = 10000;

    @Test(description = "")
    public void test123() throws Exception {
        int[] w = new int[]{3, 14, 1, 7};
        Solution solution = new Solution(w);
        for (int i = 0; i < n; i++) {
            int res = solution.pickIndex();
            int key = w[res];
            int x = memo.getOrDefault(key, 0);
            memo.put(key, x + 1);
        }
    }

    @AfterClass
    public void test() throws Exception {
        for (Map.Entry entry : memo.entrySet()) {
            int value = (int) entry.getValue();
            System.out.println(entry.getKey() + ": " + (double) value / n);
        }
    }
}

class Solution {

    int[] weight;

    public Solution(int[] w) {
        weight = new int[w.length];
        weight[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            weight[i] = weight[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int n = weight.length;
        Random random = new Random();
        int target = random.nextInt(weight[n - 1]);
        int l = 0, r = n - 1;
        int idx = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (weight[mid] > target) {
                idx = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return idx;
    }

}
