package Lc.backtrack;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/restore-ip-addresses/?show=1">no93 有效ip地址</a>
 **/
public class No93 {

    List<String> res = new ArrayList<>();
    int dot = 3;


    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> path = new ArrayList<>();
        backtrack(path, 0, s);


        return res;
    }

    public void backtrack(ArrayList<String> path, int cur, String s) {
        if (path.size() >= 4) {
            return;
        }
        if (dot == 0 && path.size() == 3) {
            if (isValidIp(s.substring(cur))) {
                path.add(s.substring(cur));
                String tmp = String.join(".", path);
                res.add(tmp);
                path.remove(path.size() - 1);
                return;
            }
        }
        for (int i = cur + 1; i < s.length() + 1; i++) {
            boolean isOk = isValidIp(s.substring(cur, i));
            if (!isOk) {
                continue;
            }
            // 加入path
            path.add(s.substring(cur, i));
            dot--;

            backtrack(path, i, s);

            path.remove(path.size() - 1);
            dot++;
        }
    }

    public boolean isValidIp(String s) {
        if (!s.isEmpty() && s.length() <= 3 && (!s.startsWith("0") || s.equals("0")) && Integer.parseInt(s) <= 255) {
            return true;
        }
        return false;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
//                {"0000"},
                {"25525511135"},
                {"101023"},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s) {
        res.clear();
        List<String> x = restoreIpAddresses(s);
        System.out.println(StringUtils.join(x, ";"));
        System.out.println();
    }
}
