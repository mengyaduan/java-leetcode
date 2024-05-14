package designpatterns.structuralpatterns.adapter;

/**
 * 对象适配器模式
 */
public class EncodeAdapter implements IEncoder {
    EncodeModule encodeModule = new EncodeModule();


    @Override
    public String encode(String mobile, String email, String key) {
        String text = mobile + email;
        return encodeModule.encode(text, key);
    }

    @Override
    public String decode(String encodeStr, String key) {
        return encodeModule.decode(encodeStr, key);
    }
}
