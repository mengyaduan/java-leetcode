package Lc119;

public class LCR005 {

    public int maxProduct(String[] words) {
        int result = 0;
        int[][] helper = new int[words.length][26];
        // 初始化数据
        for (int i = 0; i < words.length; i++) {
            init(helper[i], words[i]);
        }
        // 遍历对比
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                boolean same = compare(i, j, helper);
                if (same) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }

    private boolean compare(int x, int y, int[][] helper) {
        for (int i = 0; i < 26; i++) {
            if (helper[x][i] > 0 && helper[y][i] > 0) {
                return false;
            }
        }
        return true;
    }

    private void init(int[] helper, String word) {
        for (char c : word.toCharArray()) {
            helper[c - 'a'] += 1;
        }


    }


    public int maxProductBeautiful(String[] words) {
        int length = words.length;
        int[] masks = new int[length];
        for (int i = 0; i < length; i++) {
            String word = words[i];
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                masks[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        int maxProd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }
        return maxProd;
    }

}
