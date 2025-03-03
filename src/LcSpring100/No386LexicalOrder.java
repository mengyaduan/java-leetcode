package LcSpring100;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class No386LexicalOrder {

    List<Integer> result;

    public List<Integer> lexicalOrder(int n) {
        result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            // 对1-9，进行遍历
            dfs(i, n);
        }
        return result;
    }

    private void dfs(int i, int n) {
        if (i > n) {
            return;
        }
        result.add(i);
        for (int j = 0; j < 10; j++) {
            dfs(i * 10 + j, n);
        }
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(lexicalOrder(112));

    }
}
