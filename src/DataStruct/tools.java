package DataStruct;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * 刷题工具
 **/
public class tools {
    public static int[] string2IntArray(String s) {
        String[] tmp = StringUtils.split(s, ",");
        return Arrays.stream(tmp).map(String::trim).mapToInt(Integer::parseInt).toArray();
    }
}

