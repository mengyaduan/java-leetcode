package lc150;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/text-justification/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No68FulJustify {


    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        // 定义宽度为16的char[]
        int i = 0;
        // step1 计算本轮可以放入的单词数（单词长度+单词个数减1的空格）
        boolean tail = false;
        while (i < words.length) {
            int wordLen = 0;
            ArrayList<String> q = new ArrayList<>();
            for (; i < words.length; i++) {
                // 查看当前词汇是否符合添加条件
                boolean canJoin = wordLen + q.size() + words[i].length() <= maxWidth;
                if (!canJoin) {
                    break;
                }
                if (i == words.length - 1) {
                    tail = true;
                }
                wordLen += words[i].length();
                q.add(words[i]);
            }
            // 处理当前的q
            int blankNum = maxWidth - wordLen;
            result.add(process(q, blankNum, maxWidth, tail));
            // 继续下一轮
        }
        return result;
    }

    private String process(ArrayList<String> q, int blankNum, int maxWidth, boolean tail) {
        int wordCount = q.size();
        String[] empty = new String[wordCount - 1];
        int b;
        String baseEmpty = " ";
        if (!tail) {
            // 每个间隙一定多少个空格
            int a = blankNum / (q.size() - 1);
            char[] charArray = new char[a];
            Arrays.fill(charArray, ' ');
            baseEmpty = new String(charArray);
            // 前b个间隙要多1个
            b = blankNum % (q.size() - 1);
        } else {
            b = 0;
        }
        for (int i = 0; i < empty.length; i++) {
            empty[i] = baseEmpty + (b > 0 ? " " : "");
            b--;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < q.size(); i++) {
            res.append(q.get(i));
            if (i < empty.length) {
                res.append(empty[i]);
            }
        }
        String s = res.toString();
        if (tail && s.length() < maxWidth) {
            char[] charArray = new char[maxWidth - s.length()];
            Arrays.fill(charArray, ' ');
            String suffix = new String(charArray);
            s += suffix;
        }
        return s;
    }

    @Test(description = "")
    public void test() throws Exception {
        String[] words = new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        int maxWidth = 20;
        List<String> x = fullJustify(words, maxWidth);
        for (String item : x) {
            System.out.println(item.length());
            System.out.println(item + "|");
        }

    }
}