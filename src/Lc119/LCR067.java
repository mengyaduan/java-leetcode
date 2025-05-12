package Lc119;

import DataStruct.TrieNode;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LCR067 {

    public int findMaximumXOR(int[] nums) {
        // 转2进制，找到最长数据
        String[] ns = new String[nums.length];
        int maxLen = 0;
        for (int i = 0; i < ns.length; i++) {
            ns[i] = Integer.toBinaryString(nums[i]);
            maxLen = Math.max(maxLen, ns[i].length());
        }
        // 针对不够长度的补0
        for (int i = 0; i < ns.length; i++) {
            if (ns[i].length() < maxLen) {
                ns[i] = String.format("%" + maxLen + "s", ns[i]).replace(' ', '0');
            }
        }
        // 录入trie
        ZoNode root = new ZoNode();
        for (int i = 0; i < ns.length; i++) {
            ZoNode cur = root;
            for (char c : ns[i].toCharArray()) {
                if (cur.child[c - '0'] == null) {
                    cur.child[c - '0'] = new ZoNode();
                }
                cur = cur.child[c - '0'];
            }
            cur.isEnd = true;
            cur.value = nums[i];
        }
        // nums至少有一个数
        int result = 0;
        // 遍历所有数字，找到最大值
        for (int i = 0; i < ns.length; i++) {
            char[] item = ns[i].toCharArray();
            ZoNode cur = root;
            int idx = 0;
            while (idx < item.length) {
                char exp = item[idx] == '0' ? '1' : '0';
                if (cur.child[exp - '0'] != null) {
                    cur = cur.child[exp - '0'];
                } else {
                    cur = cur.child[item[idx] - '0'];
                }
                idx++;
            }
            result = Math.max(result, nums[i] ^ cur.value);
        }
        return result;
    }


    @DataProvider(name = "unit")
    public Object[][] unit() {
        return new Object[][]{
                {new int[]{2, 3, 5, 10, 25, 8}, 28},
                {new int[]{2}, 0},
                {new int[]{1}, 0},
                {new int[]{8, 10, 2}, 10},
                {new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70}, 127},
        };
    }

    @Test(description = "", dataProvider = "unit")
    public void test(int[] nums, int result) throws Exception {
        Assert.assertEquals(findMaximumXOR(nums), result);

    }


}

class ZoNode {
    boolean isEnd;
    int value;
    ZoNode[] child;

    ZoNode() {
        child = new ZoNode[2];
    }

}
