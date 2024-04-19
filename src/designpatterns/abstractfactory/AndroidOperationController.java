package designpatterns.abstractfactory;

public class AndroidOperationController implements IOperationController {
    @Override
    public void showOperation() {
        System.out.println("AND show operation");
    }
}
