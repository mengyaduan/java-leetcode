package lc75;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/counting-bits/description/?envType=study-plan-v2&envId=leetcode-75">计算bit</a>
 */
public class No338_countBits {

    public int[] countBits(int n) {
        if (n == 0) {
            return new int[]{0};
        }
        int[] res = new int[n + 1];
        // 最接近2的幂次的值
        int nearest2Idx = 1;
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i == nearest2Idx * 2) {
                res[i] = 1;
                nearest2Idx = i;
                continue;
            }
            int rest = i - nearest2Idx;
            res[i] = res[nearest2Idx] + res[rest];
        }
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[] x = countBits(8);
        System.out.println(StringUtils.join(Arrays.stream(x).mapToObj(String::valueOf).toArray(), ","));

    }
}
