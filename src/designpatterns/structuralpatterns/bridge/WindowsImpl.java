package designpatterns.structuralpatterns.bridge;

public class WindowsImpl implements DataTransImpl{
    @Override
    public void doTrans() {
        System.out.println("windows 转换");
    }
}
