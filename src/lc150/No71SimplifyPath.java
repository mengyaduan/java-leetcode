package lc150;

import org.testng.annotations.Test;

import java.util.Stack;

/*
 * @see <a herf="https://leetcode.cn/problems/simplify-path/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No71SimplifyPath {

    public String simplifyPath(String path) {
        // 先将所有连续的/都处理掉
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.length(); i++) {
            if (i > 0) {
                if (path.charAt(i) == '/' && path.charAt(i - 1) == '/') {
                    continue;
                }
            }
            sb.append(path.charAt(i));
        }
        String pathNew = sb.toString();
        char[] pc = pathNew.toCharArray();
        int i = 0;
        Stack<String> helper = new Stack<>();
        // 将字符串按照/xx的格式分割
        while (i < pc.length) {
            String pathItem = "";
            StringBuilder item = new StringBuilder();
            if (pc[i] == '/') {
                item.append('/');
                i++;
                while (i < pc.length && pc[i] != '/') {
                    item.append(pc[i]);
                    i++;
                }
                pathItem = item.toString();
            }
            if (pathItem.equals("/..")) {
                if(!helper.isEmpty()) {
                    helper.pop();
                }
            } else if (pathItem.equals("/.")) {
                continue;
            } else if (pathItem.equals("/")) {
                continue;
            } else {
                helper.push(pathItem);
            }
        }
        if (helper.isEmpty()) {
            return "/";
        }

        String res = "";
        while (!helper.isEmpty()) {
            res = helper.pop() + res;
        }
        return res;
    }


    @Test
    public void test() {
        System.out.println(simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/a/./b/../../c.../.../"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/../"));

    }

}
