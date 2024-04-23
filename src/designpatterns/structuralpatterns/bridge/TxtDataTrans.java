package designpatterns.structuralpatterns.bridge;

public class TxtDataTrans extends DataTrans{

    @Override
    public void transFile(String fileName) {
        System.out.println("txt转换启动");
        imp.doTrans();
        System.out.println("txt转换结束");
    }
}
