package Lc.KrahetsInterview.Math;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No89_GrayCode {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> base = new ArrayList<>(Arrays.asList(0, 1));
        int i = 1;
        int bit = 1;
        while (i < n) {
            bit <<= 1;
            int baseSizeNow = base.size();
            for (int j = baseSizeNow - 1; j >= 0; j--) {
                base.add(bit + base.get(j));
            }
            i++;
        }
        return base;
    }

    @Test(description = "")
    public void test() throws Exception {
        List<Integer> x = grayCode(3);
        System.out.println(StringUtils.join(x, ","));
        List<Integer> y = grayCode(4);
        System.out.println(StringUtils.join(y, ","));

    }
}
