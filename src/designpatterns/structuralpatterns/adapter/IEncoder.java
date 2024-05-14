package designpatterns.structuralpatterns.adapter;

/**
 * 抽象目标类，客户端直接调用这个方法就行了
 */
public interface IEncoder {

    String encode(String mobile, String email, String key);

    String decode(String encodeStr, String key);

}
