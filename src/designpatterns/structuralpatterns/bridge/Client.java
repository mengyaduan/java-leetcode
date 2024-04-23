package designpatterns.structuralpatterns.bridge;

public class Client {
    public static void main(String[] args) {
        DataTrans dt;
        DataTransImpl imp;
        dt = new TxtDataTrans();
        imp = new WindowsImpl();
        dt.setImp(imp);
        dt.transFile("hello");

        dt = new XmlDataTrans();
        dt.setImp(imp);
        dt.transFile("world");
    }


}
