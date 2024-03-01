package Lc.string;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/validate-ip-address/description/">验证ip地址</a>
 **/
public class No468_ValidIPAddress {
    public String validIPAddress(String queryIP) {
        if (queryIP.contains(".")) {
            return validIpV4(queryIP) ? "IPv4" : "Neither";
        }
        if (queryIP.contains(":")) {
            return validIpV6(queryIP) ? "IPv6" : "Neither";
        }
        return "Neither";
    }

    public boolean validIpV4(String queryIp) {
        String[] addrs = queryIp.split("\\.", -1);
        // 排除长度
        if (addrs.length != 4) {
            return false;
        }
        for (String item : addrs) {
            // 排除长度 和 前导零
            if (item.isEmpty() || item.length() > 3 || (item.length() > 1 && item.charAt(0) == '0')) {
                return false;
            }
            // 排除字符
            for (char c : item.toCharArray()) {
                if (!(c >= '0' && c <= '9')) {
                    return false;
                }
            }
            // 转成数字比大小
            int num = Integer.parseInt(item);
            if (num > 255) {
                return false;
            }
        }
        return true;
    }

    public boolean validIpV6(String queryIp) {
        String[] addrs = queryIp.split(":", -1);
        if (addrs.length != 8) {
            return false;
        }
        for (String item : addrs) {
            // 排除长度
            if (item.isEmpty() || item.length() > 4) {
                return false;
            }
            // 排除错误字符
            for (char c : item.toCharArray()) {
                boolean isBottom = c >= 'a' && c <= 'f';
                boolean isUpper = c >= 'A' && c <= 'F';
                boolean isNum = c >= '0' && c <= '9';
                if (!(isBottom || isUpper || isNum)) {
                    return false;
                }
            }
        }
        return true;
    }


    @Test(description = "")
    public void test() throws Exception {
        System.out.println(validIPAddress("192.0.0.1"));
//        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
//        System.out.println(validIPAddress("256.256.256.256"));
//        System.out.println(validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334"));
//        System.out.println(validIPAddress("2001:0db8:85a3::8A2E:037j:7334"));
//        System.out.println(validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"));

    }

}

