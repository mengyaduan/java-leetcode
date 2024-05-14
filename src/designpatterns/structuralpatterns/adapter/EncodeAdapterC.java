package designpatterns.structuralpatterns.adapter;

/**
 * 类适配器模式：只有目标抽象类是接口时，java才能用，否则无法应用
 */
public class EncodeAdapterC extends EncodeModule implements IEncoder {
    @Override
    public String encode(String mobile, String email, String key) {
        return encode(mobile + email, key);
    }

    @Override
    public String decode(String encodeStr, String key) {
        return decode(encodeStr, key);
    }
}
