package Lc;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href=""></a>
 **/
public class template {

    public double hello() {
        return 0.0;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{2}, new int[]{}, 2},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] nums1, int[] nums2, double expected) {
        double res = hello();
        Assert.assertEquals(res, expected);
    }
}
