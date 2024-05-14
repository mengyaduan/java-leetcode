package designpatterns.structuralpatterns.adapter;

/**
 * Adaptee：三方实现的加密模块，支持加密方法
 */
public class EncodeModule {

    public String encode(String text, String keys) {
        return "三方加密后：" + text + keys;
    }

    public String decode(String text, String keys) {
        return "三方解密后：" + text + keys;
    }
}
