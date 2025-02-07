package LcSpring100;

import org.testng.annotations.Test;

public class No165CompareVersion {

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len = Math.max(v1.length, v2.length);
        for (int i = 0; i < len; i++) {
            int a = i >= v1.length ? 0 : Integer.parseInt(v1[i]);
            int b = i >= v2.length ? 0 : Integer.parseInt(v2[i]);
            if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;
            }
        }
        return 0;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(compareVersion("1.2", "1.10"));
    }
}
