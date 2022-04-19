package Lc.greedy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/text-justification/description/?spm=ata.21736010.0.0.7d9c605f3Fv129/">no68:两边对齐</a>
 **/
public class No68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        // No1. 遍历，找到每行的临界点
        // len1 = 前n个词的长度+（n-1）个空格 <= maxWidth: this is an = 4+2+2+2 = 10<16
        // len2 = 前n+1个词的长度 + (n)个空格 > maxWidth: this is an example=4+2+2+7+3=18>16
        // 所以第一排，只有三个词 this is an
        // No2. 分配空格
        // n-1个空，maxWidth - len1 + (n-1) 个空格，先平均分，余数家在左边追加过来
        // 如果是最后一行，直接用空格填补即可
        List<String> res = new ArrayList<>();
        int start = 0;
        while (start < words.length) {
            // 左闭右开
            int begin = start;
            int end = getOneLine(words, maxWidth, start);
            String thisTurn = "";
            ArrayList<String> content = new ArrayList<>();
            int length = 0;
            for (int i = begin; i < end; i++) {
                content.add(words[i]);
                length += words[i].length();
            }
            int needBlank = maxWidth - length;
            int count = end - start - 1;
            boolean isLastLine = end >= words.length ? true : false;
            if (needBlank > 1 && isLastLine) {
                count += 1;
            }
            ArrayList<String> blank = createBlank(needBlank, count, isLastLine);
            int i = 0;
            while (i < content.size() && i < blank.size()) {
                thisTurn += content.get(i);
                thisTurn += blank.get(i);
                i++;
            }
            while (i >= content.size() && i < blank.size()) {
                thisTurn += blank.get(i);
                i++;
            }
            while (i < content.size() && i >= blank.size()) {
                thisTurn += content.get(i);
                i++;
            }
            res.add(thisTurn);
            // 进行下一轮
            start = end;
        }
        return res;
    }

    /**
     * 得到每一行能展示的最后一个word的index
     *
     * @param words
     * @param maxWidth
     * @param start
     * @return
     */
    public int getOneLine(String[] words, int maxWidth, int start) {
        int len1 = 0;
        int end = 0;
        for (int i = start; i < words.length; i++) {
            len1 += words[i].length();
            if (len1 > maxWidth) {
                end = i;
                break;
            }
            // 补空格
            len1++;
        }
        if (end == 0) {
            end = words.length;
        }
        return end;
    }


    /**
     * @param needBlank 需要填充的空格
     * @param count     填补空格的坑位
     * @return
     */
    public ArrayList<String> createBlank(int needBlank, int count, boolean isLastLine) {
        ArrayList<String> res = new ArrayList<>();
        if (count == 0) {
            String tmp = "";
            for (int j = 0; j < needBlank; j++) {
                tmp += " ";
            }
            res.add(tmp);
            return res;
        }
        int average = needBlank / count;
        int rest = needBlank % count;
        if (!isLastLine) {
            for (int i = 0; i < count; i++) {
                String tmp = "";
                for (int j = 0; j < average; j++) {
                    tmp += " ";
                }

                if (rest > 0) {
                    tmp += " ";
                    rest--;
                }
                res.add(tmp);
            }
        } else {
            for (int i = 0; i < count; i++) {
                if (i == count - 1) {
                    // 最后一行的最后一个词，要填充空格
                    String tmp = "";
                    for (int j = 0; j < needBlank - (count - 1); j++) {
                        tmp += " ";
                    }
                    res.add(tmp);
                } else {
                    res.add(" ");
                }
            }
        }
        return res;
    }

    @Test(description = "")
    public void testSplit() throws Exception {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int x = getOneLine(words, 16, 0);
        int y = getOneLine(words, 16, 3);
        int z = getOneLine(words, 16, 6);
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);

    }

    @DataProvider(name = "test")
    public Object[][] test() {
        Object[][] data = {
                //
                {"", new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16},
                {"", new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16},
                {"", new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20},
        };
        return data;
    }

    @Test(description = "", dataProvider = "test")
    public void testAll(String desc, String[] words, int maxWidth) throws Exception {
        List<String> x = fullJustify(words, maxWidth);
        System.out.println(desc);
        for (String item : x) {
            System.out.println("-" + item + "-");
        }
    }


}

