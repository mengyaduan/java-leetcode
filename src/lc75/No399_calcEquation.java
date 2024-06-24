package lc75;

import com.sun.xml.internal.messaging.saaj.soap.GifDataContentHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.*;

/**
 * @see <a href="https://leetcode.cn/problems/evaluate-division/description/?envType=study-plan-v2&envId=leetcode-75">除法求值</a>
 */
public class No399_calcEquation {

    HashMap<String, HashMap<String, Double>> relationTable;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        relationTable = new HashMap<>();
        // 初始化数据
        Deque<Relation> helper = new ArrayDeque<>();
        for (int i = 0; i < values.length; i++) {
            helper.add(new Relation(equations.get(i).get(0), equations.get(i).get(1), values[i]));
        }
        while (!helper.isEmpty()) {
            Relation added = helper.pollFirst();
            update(added, helper);
        }
        //处理结果
        double[] res = new double[queries.size()];
        int i = 0;
        for (List<String> query : queries) {
            String a = query.get(0);
            String b = query.get(1);
            if (a.equals(b)) {
                res[i++] = relationTable.containsKey(a) ? 1.0 : -1.0;
                continue;
            }
            if (!relationTable.containsKey(a) || !relationTable.get(a).containsKey(b)) {
                res[i++] = -1;
            } else {
                res[i++] = relationTable.get(a).get(b);
            }
        }
        return res;
    }

    private void update(Relation added, Deque<Relation> helper) {
        String a = added.a;
        String b = added.b;
        double val = added.val;
        relationTable.putIfAbsent(a, new HashMap<>());
        relationTable.putIfAbsent(b, new HashMap<>());
        if (relationTable.get(a).containsKey(b)) {
            // ab已经建立过关系，直接return
            return;
        }
        // 分别更新ab
        relationTable.get(a).put(b, val);
        relationTable.get(b).put(a, 1 / val);
        // 将b关联关系中所有数据加入helper
        HashMap<String, Double> itemB = relationTable.get(b);
        for (Map.Entry<String, Double> entry : itemB.entrySet()) {
            if (entry.getKey().equals(a)) {
                continue;
            }
            helper.add(new Relation(a, entry.getKey(), val * entry.getValue()));
        }
        // 将a关联关系中的所有数据加入helper
        HashMap<String, Double> itemA = relationTable.get(a);
        for (Map.Entry<String, Double> entry : itemA.entrySet()) {
            if (entry.getKey().equals(b)) {
                continue;
            }
            helper.add(new Relation(b, entry.getKey(), entry.getValue() / val));
        }
    }

    class Relation {
        String a;
        String b;
        double val;

        public Relation(String a, String b, double val) {
            this.a = a;
            this.b = b;
            this.val = val;
        }

    }


    @Test(description = "")
    public void test3() throws Exception {
        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<>(Arrays.asList("a", "b")));
        equations.add(new ArrayList<>(Arrays.asList("e", "f")));
        equations.add(new ArrayList<>(Arrays.asList("b", "e")));
        double[] values = new double[]{3.4, 1.4, 2.3};
        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<>(Arrays.asList("b", "a")));
        queries.add(new ArrayList<>(Arrays.asList("a", "f")));
        queries.add(new ArrayList<>(Arrays.asList("f", "f")));
        queries.add(new ArrayList<>(Arrays.asList("e", "e")));
        queries.add(new ArrayList<>(Arrays.asList("c", "c")));
        queries.add(new ArrayList<>(Arrays.asList("a", "c")));
        queries.add(new ArrayList<>(Arrays.asList("f", "e")));
        double[] x = calcEquation(equations, values, queries);
        System.out.println(StringUtils.join(Arrays.stream(x).mapToObj(String::valueOf).toArray(), ", "));

    }


    @Test(description = "")
    public void test2() throws Exception {
        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<>(Arrays.asList("a", "b")));
        equations.add(new ArrayList<>(Arrays.asList("b", "c")));
        equations.add(new ArrayList<>(Arrays.asList("bc", "cd")));
        double[] values = new double[]{1.5, 2.5, 5.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<>(Arrays.asList("a", "c")));
        queries.add(new ArrayList<>(Arrays.asList("c", "b")));
        queries.add(new ArrayList<>(Arrays.asList("bc", "cd")));
        queries.add(new ArrayList<>(Arrays.asList("cd", "bc")));
        double[] x = calcEquation(equations, values, queries);
        System.out.println(StringUtils.join(Arrays.stream(x).mapToObj(String::valueOf).toArray(), ", "));

    }

    @Test(description = "")
    public void test() throws Exception {
        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<>(Arrays.asList("a", "b")));
        equations.add(new ArrayList<>(Arrays.asList("b", "c")));
        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<>(Arrays.asList("a", "c")));
        queries.add(new ArrayList<>(Arrays.asList("b", "a")));
        queries.add(new ArrayList<>(Arrays.asList("b", "e")));
        queries.add(new ArrayList<>(Arrays.asList("a", "a")));
        queries.add(new ArrayList<>(Arrays.asList("x", "x")));
        double[] x = calcEquation(equations, values, queries);
        System.out.println(StringUtils.join(Arrays.stream(x).mapToObj(String::valueOf).toArray(), ", "));

    }
}
