package LcSpring100;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No218GetSkyline {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        int start = buildings[0][0];
        int end = buildings[buildings.length - 1][1];
        int curHeight = -1;
        // 只需要遍历每个建筑的左右节点就可以了
        int[] buildingsEdge = new int[buildings.length * 2];
        int idx = 0;
        for (int[] building : buildings) {
            buildingsEdge[idx] = building[0];
            buildingsEdge[idx + 1] = building[1];
            idx += 2;
        }
        Arrays.sort(buildingsEdge);
        // 从左到右遍历，找到变化点
        int lastOne = -1;
        for (int i : buildingsEdge) {
            if (i == lastOne) {
                // 避免重复计算
                continue;
            }
            lastOne = i;
            int heightNow = 0;
            for (int[] build : buildings) {
                if (i < build[0]) {
                    break;
                }
                if (i < build[1]) {
                    heightNow = Math.max(heightNow, build[2]);
                }
            }
            if (heightNow != curHeight) {
                curHeight = heightNow;
                result.add(new ArrayList<>(Arrays.asList(i, heightNow)));
            }
        }
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[][] array = {
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12},
                {15, 20, 10},
                {19, 24, 8}
        };
        System.out.println(getSkyline(array));

    }

    @Test(description = "")
    public void test1() throws Exception {
        int[][] array = {
                {0, 2147483647, 2147483647}
        };
        System.out.println(getSkyline(array));

    }
}
