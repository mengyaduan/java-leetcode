package designpatterns.structuralpatterns.adapter;

public class Client {
    public static void main(String[] args) {
        IEncoder encoder = new EncodeAdapter();
        String encodeStr = encoder.encode("mobile", "email", "kkk");
        System.out.println(encodeStr);
        String decodeStr = encoder.decode(encodeStr, "yyy");
        System.out.println(decodeStr);
    }
}
