package Lc.backtrack;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/generate-parentheses/?show=1">No22 括号生成</a>
 **/
public class No22OverLimit {


    HashSet<String> resSet = new HashSet<>();
    HashSet<Integer> indexUsed = new HashSet<>();


    public List<String> generateParenthesis(int n) {
        // 根据n获得全部字符集和
        ArrayList<String> selectedList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            selectedList.add("(");
            selectedList.add(")");
        }
        // 全排列集合，然后只记录可用的即可，记录到set里面(重复概率很高)
        ArrayList<String> path = new ArrayList<>();
        for (int i = 0; i < selectedList.size(); i++) {
            backtrack(path, selectedList);
        }

        return new ArrayList<String>(resSet);

    }

    /**
     * 括号是否匹配
     *
     * @param tempPath
     * @return
     */
    public boolean isParenthesisOk(String tempPath) {
        int stackLeft = 0;
        for (int i = 0; i < tempPath.length(); i++) {
            if (tempPath.charAt(i) == '(') {
                stackLeft++;
            } else if (tempPath.charAt(i) == ')' && stackLeft > 0) {
                stackLeft--;
            }
        }
        return stackLeft == 0;
    }

    public void backtrack(ArrayList<String> path, ArrayList<String> selectedList) {
        // 回溯中止条件
        String pathNow = String.join("", path);
        int left = 0;
        int right = 0;
        for (String item : path) {
            if (item.equals("(")) {
                left++;
            } else {
                right++;
                if (right > left) {
                    return;
                }
            }
        }
        if (pathNow.length() == selectedList.size() && isParenthesisOk(pathNow)) {
            resSet.add(pathNow);
            return;
        }
        for (int i = 0; i < selectedList.size(); i++) {
            if (!indexUsed.contains(i)) {
                // 路径加入，从选择列表中剔除
                path.add(selectedList.get(i));
                indexUsed.add(i);

                backtrack(path, selectedList);

                // 从路径中删除，加会选择列表
                int len = path.size();
                path.remove(len - 1);
                indexUsed.remove(i);
            }
        }
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {3},
                {1},
                {8}
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int n) {
        resSet.clear();
        List<String> x = generateParenthesis(n);
        System.out.println(x);

//        Assert.assertTrue(res.size() == resultExpected.size());
//        for (String item : resultExpected) {
//            Assert.assertTrue(res.contains(item));
//        }
    }

}
