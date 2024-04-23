package designpatterns.structuralpatterns.bridge;

public class IosImpl implements DataTransImpl{
    @Override
    public void doTrans() {
        System.out.println("ios 转换");
    }
}
