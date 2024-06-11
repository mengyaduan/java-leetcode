package lc75;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/kids-with-the-greatest-number-of-candies/description/?envType=study-plan-v2&envId=leetcode-75"></a>
 */
public class No1431_KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int topNum = 0;
        // 找到最高糖果
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > topNum) {
                topNum = candies[i];
            }
        }
        // 遍历，加起来能超过最高就行了
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= topNum) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1));
        System.out.println(kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3));
        System.out.println(kidsWithCandies(new int[]{12, 1, 12}, 10));


    }

}
