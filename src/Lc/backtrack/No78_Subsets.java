package Lc.backtrack;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/subsets/?show=1"> 子集</a>
 **/
public class No78_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            // 将已有的所有子集，加上当前的item，成为新的子集
            int times = res.size();
            for (int j = 0; j < times; j++) {
                List<Integer> setsNow = res.get(j);
                ArrayList<Integer> item = new ArrayList<>(setsNow);
                item.add(cur);
                res.add(item);
            }
            res.add(new ArrayList<>(Collections.singletonList(cur)));
        }
        // 空集合是所有人的子集
        res.add(new ArrayList<>());
        return res;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{1, 2, 3}, 2},
                {new int[]{0}, 2},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] n, int k) {
        List<List<Integer>> x = subsets(n);
        System.out.println(StringUtils.join(x, ","));
        System.out.println();
    }
}

