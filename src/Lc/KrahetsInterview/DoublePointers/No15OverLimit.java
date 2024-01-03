package Lc.KrahetsInterview.DoublePointers;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @see <a href=https://leetcode.com/problems/3sum/description/"">三数之和</a>
 **/
public class No15OverLimit {

    List<List<Integer>> res = new ArrayList<>();
    HashSet<HashSet<Integer>> helper = new HashSet<>();

    public List<List<Integer>> threeSum(int[] nums) {
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                b = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    c = nums[k];
                    if (a + b + c == 0) {
                        HashSet item = new HashSet<>();
                        item.add(a);
                        item.add(b);
                        item.add(c);
                        if (!helper.contains(item)) {
                            helper.add(item);
                            List<Integer> tmp = new ArrayList<>();
                            tmp.add(a);
                            tmp.add(b);
                            tmp.add(c);
                            res.add(tmp);
                        }
                    }
                }
            }
        }
        return res;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                //
                {new int[]{-1, 0, 1, 2, -1, -4}},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] nums) {
        res = new ArrayList<>();
        List<List<Integer>> xx = threeSum(nums);
        System.out.println(xx);

    }

}

