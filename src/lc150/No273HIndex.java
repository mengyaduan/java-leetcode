package lc150;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class No273HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = Integer.MIN_VALUE;
        for (int i = 0; i < citations.length; i++) {
            // 被引用次数
            int citation = citations[i];
            // 被引用次数大于等于当前值的文章数
            int papers = citations.length - i;
            if (papers >= citation) {
                h = Math.max(h, citation);
            } else {
                h = Math.max(papers, h);
            }
        }
        return h;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(hIndex(new int[]{1, 3, 1, 40}), 2);
        Assert.assertEquals(hIndex(new int[]{3, 0, 6, 1, 5}), 3);
        Assert.assertEquals(hIndex(new int[]{100}), 1);
        Assert.assertEquals(hIndex(new int[]{100, 200, 300}), 3);

    }
}
