package Lc.KrahetsInterview.Search;

import org.testng.annotations.Test;

import static DataStruct.tools.string2IntArray;

/**
 * @see <a href="https://leetcode.com/problems/find-the-duplicate-number/description/">找到重复的数字</a>
 **/
public class No287 {

    /**
     * 1,2,3,4 表示成4位二进制以后，每位求和，结果是 0122<p>
     * 在index=0的地方加个3，重新计算，结果是 0133<p>
     * 挑出 1 多余标准结果的位，相加就是重复的数 0011
     **/

    public int findDuplicate(int[] nums) {
        int res = 0;
        for (int k = 0; k < 32; k++) {
            int bit = 1 << k;
            int cnt1 = 0;
            int cnt2 = 0;
            for (int i = 0; i < nums.length; i++) {
                if ((i & bit) > 0) {
                    cnt1++;
                }
                if ((nums[i] & bit) > 0) {
                    cnt2++;
                }
            }
            if (cnt2 > cnt1) {
                res += bit;
            }
        }
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] nums = string2IntArray("1,3,4,2,2");
        System.out.println(findDuplicate(nums));
        int[] nums2 = string2IntArray("1,3,4,1,1");
        System.out.println(findDuplicate(nums2));

    }

}

