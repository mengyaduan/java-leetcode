package designpatterns.structuralpatterns.bridge;

public class XmlDataTrans extends DataTrans {
    @Override
    public void transFile(String fileName) {
        System.out.println("xml转换启动");
        imp.doTrans();
        System.out.println("xml转换结束");
    }
}
