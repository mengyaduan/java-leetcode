package designpatterns.creationalpatterns.abstractfactory;

public class AndroidSystemFactory implements ISystemFactory {
    @Override
    public IInterfaceController createInterfaceController() {
        return new AndroidInterfaceController();
    }

    @Override
    public IOperationController createOperationController() {
        return new AndroidOperationController();
    }
}
