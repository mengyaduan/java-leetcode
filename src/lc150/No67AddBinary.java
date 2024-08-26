package lc150;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/add-binary/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No67AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char[] x = a.toCharArray();
        char[] y = b.toCharArray();
        int flag = 0;
        int i = x.length - 1;
        int j = y.length - 1;
        while ((i >= 0 || j >= 0) || flag != 0) {
            int m = i >= 0 ? x[i] - '0' : 0;
            int n = j >= 0 ? y[j] - '0' : 0;
            int res = (m + n + flag) % 2;
            flag = (m + n + flag) / 2;
            sb.append(res);
            i--;
            j--;
        }
        return sb.reverse().toString();
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(addBinary("10", "10"));


    }
}
