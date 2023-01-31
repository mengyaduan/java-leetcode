package Lc.backtrack;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/combination-sum/?show=1">No39 组合总和</a>
 **/
public class No39 {


    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> path = new ArrayList<>();
        backtrack(candidates, path, 0, 0, target);
        return result;
    }

    public void backtrack(int[] candidates, ArrayList<Integer> path, int index, int sumNow, int target) {
        // 终止条件
        if (sumNow > target) {
            return;
        }
        if (sumNow == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 每次从第index个开始，避免出现2+3和3+2同时选中的情况
        for (int i = index; i < candidates.length; i++) {
            // 加入路径，选择列表
            path.add(candidates[i]);
            sumNow += candidates[i];

            backtrack(candidates, path, i, sumNow, target);

            // 退出路径
            int len = path.size();
            path.remove(len - 1);
            sumNow -= candidates[i];
        }
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{2, 3, 6, 7}, 7},
                {new int[]{2, 3, 5}, 8},
                {new int[]{2}, 1},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] n, int target) {
        result.clear();
        List<List<Integer>> x = combinationSum(n, target);
        System.out.println(x);

//        Assert.assertTrue(res.size() == resultExpected.size());
//        for (String item : resultExpected) {
//            Assert.assertTrue(res.contains(item));
//        }
    }

}
