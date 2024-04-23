package designpatterns.abstractfactory;

public class IOSOperationController implements IOperationController {
    @Override
    public void showOperation() {
        System.out.println("IOS show operation");
    }
}
