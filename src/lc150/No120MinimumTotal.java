package lc150;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @see <a href="https://leetcode.cn/problems/triangle/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No120MinimumTotal {


    public int minimumTotal(List<List<Integer>> triangle) {
        int result = Integer.MAX_VALUE;
        ArrayList<ArrayList<Integer>> helper = new ArrayList<>();
//        helper.add(new ArrayList<>(Arrays.asList(triangle.get(0).get(0))));
        for (int i = 0; i < triangle.size(); i++) {
            ArrayList<Integer> helperItem = new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int temp;
                if (i == 0) {
                    // 如果是首行，则直接赋值
                    temp = 0;
                } else if (j == 0) {
                    temp = helper.get(i - 1).get(j);
                } else if (j == triangle.get(i).size() - 1) {
                    temp = helper.get(i - 1).get(j - 1);
                } else {
                    temp = Math.min(helper.get(i - 1).get(j), helper.get(i - 1).get(j - 1));
                }
                int item = temp + triangle.get(i).get(j);
                helperItem.add(item);
                if (i == triangle.size() - 1) {
                    // 已经到最后一行时，记录最小值
                    result = Math.min(result, item);
                }
            }
            helper.add(helperItem);
        }
        return result;
    }


    @Test(description = "")
    public void test() throws Exception {
        int[][] triangle = {
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };

        // 使用Stream API生成List<List<Integer>>
        List<List<Integer>> generatedTriangle = IntStream.range(0, triangle.length)
                .mapToObj(i -> IntStream.range(0, triangle[i].length)
                        .mapToObj(j -> triangle[i][j])
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
        System.out.println(minimumTotal(generatedTriangle));

    }
}
