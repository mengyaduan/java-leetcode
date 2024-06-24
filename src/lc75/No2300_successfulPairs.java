package lc75;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/successful-pairs-of-spells-and-potions/description/?envType=study-plan-v2&envId=leetcode-75">咒语和药水的成功对数</a>
 */
public class No2300_successfulPairs {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            long x = success / spells[i];
            int y = success % spells[i] == 0 ? 0 : 1;
            long needed = (success / spells[i] + (success % spells[i] == 0 ? 0 : 1));
            int idx = find(potions, needed);
            if (idx < 0 || idx >= potions.length) {
                res[i] = 0;
            } else {
                res[i] = potions.length - idx;
            }
        }
        return res;
    }

    private int find(int[] potions, long needed) {
        int l = 0, r = potions.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (potions[mid] >= needed) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] spells = new int[]{3, 1, 2};
        int[] potions = new int[]{8, 5, 8};
        int[] x = successfulPairs(spells, potions, 16);
        System.out.println(StringUtils.join(Arrays.stream(x).mapToObj(String::valueOf).toArray(), ","));


    }

}
