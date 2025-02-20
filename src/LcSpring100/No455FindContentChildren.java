package LcSpring100;

import java.util.Arrays;

public class No455FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        // 将小孩子的胃口排序
        Arrays.sort(g);
        int result = 0;
        int[] used = new int[g.length];
        for (int cookie : s) {
            //  对于每块饼干，找到其能喂饱的最大的胃口
            int idx2Feed = -1;
            for (int i = 0; i < g.length; i++) {
                if (used[i] == 1) {
                    continue;
                }
                if (g[i] > cookie) {
                    break;
                }
                idx2Feed = i;
            }
            if (idx2Feed != -1) {
                used[idx2Feed] = 1;
                result++;
            }
        }
        return result;
    }


}
