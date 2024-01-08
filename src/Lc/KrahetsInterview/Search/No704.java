package Lc.KrahetsInterview.Search;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static DataStruct.tools.string2IntArray;

/**
 * @see <a href="https://leetcode.com/problems/binary-search/description/">二分查找</a>
 **/
public class No704 {

    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                //
                {"-1,0,3,5,9,12", 0, 1},
                {"-1", -1, 0},
                {"-1", -2, -1},
                {"-1,0,3,5,9,12", 12, 5},
                {"-1,0,3,5,9,12", 13, -1},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, int target, int expected) {
        int[] nums = string2IntArray(s);
        int res = search(nums, target);
        Assert.assertEquals(res, expected);

    }

}

