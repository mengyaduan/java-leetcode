package Lc;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/maximum-consecutive-floors-without-special-floors/description/?envType=daily-question&envId=2025-01-06"></a>
 */
public class No2274MaxConsecutive {
    public int maxConsecutiveComplex(int bottom, int top, int[] special) {
        int result = 0;
        Arrays.sort(special);
        int idxSpLow = 0, idxSpHigh = special.length - 1;
        while (idxSpLow < special.length && bottom == special[idxSpLow]) {
            bottom += 1;
            idxSpLow++;
        }
        while (idxSpHigh >= 0 && top == special[idxSpHigh]) {
            top--;
            idxSpHigh--;
        }
        if (top < bottom) {
            return 0;
        }
        ArrayList<Integer> separate = new ArrayList<>();
        separate.add(bottom - 1);
        for (int i = idxSpLow; i <= idxSpHigh; i++) {
            separate.add(special[i]);
        }
        separate.add(top + 1);
        for (int i = 1; i < separate.size(); i++) {
            result = Math.max(result, separate.get(i) - separate.get(i - 1) - 1);
        }
        return result;
    }

    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int result = Math.max(special[0] - bottom, top - special[special.length - 1]);
        for (int i = 1; i < special.length; i++) {
            result = Math.max(result, special[i] - special[i - 1] - 1);
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertTrue(maxConsecutive(2, 9, new int[]{4, 6}) == 3);
        Assert.assertTrue(maxConsecutive(2, 9, new int[]{2, 4, 6, 9}) == 2);
        Assert.assertTrue(maxConsecutive(2, 9, new int[]{4, 6, 7, 8, 9}) == 2);
        Assert.assertTrue(maxConsecutive(2, 9, new int[]{2, 3, 4, 5, 6, 7, 8}) == 1);
        Assert.assertTrue(maxConsecutive(2, 9, new int[]{3, 4, 5, 6, 7, 8, 9}) == 1);
        Assert.assertTrue(maxConsecutive(2, 9, new int[]{2, 3, 4, 5, 6, 7, 8, 9}) == 0);
        Assert.assertTrue(maxConsecutive(6, 8, new int[]{7, 6, 8}) == 0);
    }
}
