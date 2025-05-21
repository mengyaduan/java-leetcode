package Lc119;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LCR087 {

    List<String> result;

    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(String s, int idx, List<String> path) {
        if (idx >= s.length() || path.size() > 4) {
            if (path.size() == 4) {
                result.add(String.join(".", path));
            }
            return;
        }
        for (int i = idx + 1; i <= Math.min(s.length(), idx + 3); i++) {
            String part = s.substring(idx, i);
            if (valid(part)) {
                path.add(part);
                backtrack(s, i, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean valid(String part) {
        if (part.isEmpty() || part.length() > 1 && part.startsWith("0")) {
            return false;
        }
        return Integer.parseInt(part) <= 255;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(restoreIpAddresses("010010"));
        System.out.println(restoreIpAddresses("10203040"));
        System.out.println(restoreIpAddresses("1111"));

    }
}
