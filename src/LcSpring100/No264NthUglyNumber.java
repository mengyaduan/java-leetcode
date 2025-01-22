package LcSpring100;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class No264NthUglyNumber {


    public int nthUglyNumber(int n) {
        ArrayList<Integer> helper = new ArrayList<>();
        helper.add(1);
        int i = 0, j = 0, k = 0;
        while (helper.size() < n) {
            int a = 2 * helper.get(i);
            int b = 3 * helper.get(j);
            int c = 5 * helper.get(k);
            int item = Math.min(a, Math.min(b, c));
            helper.add(item);
            if (item == a) i++;
            if (item == b) j++;
            if (item == c) k++;
        }
        return helper.get(n - 1);
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(nthUglyNumber(10));

    }
}


