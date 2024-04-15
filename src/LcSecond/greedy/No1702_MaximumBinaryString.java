package LcSecond.greedy;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/maximum-binary-string-after-change/description/?envType=daily-question&envId=2024-04-10">修改后的最大二进制字符串</a>
 **/
public class No1702_MaximumBinaryString {

    public String maximumBinaryString(String binary) {
        int zeros = binary.length() - binary.replaceAll("0", "").length();
        int preOnes = 0;
        for (char item : binary.toCharArray()) {
            if (item != '1') {
                break;
            } else {
                preOnes++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < preOnes; i++) {
            stringBuilder.append("1");
        }
        for (int i = 0; i < zeros - 1; i++) {
            stringBuilder.append("1");
        }
        stringBuilder.append("0");
        for (int i = 0; i < binary.length() - preOnes - zeros; i++) {
            stringBuilder.append("1");
        }
        return stringBuilder.toString();

    }


    @Test(description = "")
    public void test() throws Exception {
        System.out.println(maximumBinaryString("1001010101010011101"));
        System.out.println(maximumBinaryString("101010011101"));
//        String binary = "000110";
//        System.out.println(maximumBinaryString(binary));
//        System.out.println(maximumBinaryString("01"));
    }

}

