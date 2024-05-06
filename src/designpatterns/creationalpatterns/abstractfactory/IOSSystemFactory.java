package designpatterns.creationalpatterns.abstractfactory;

public class IOSSystemFactory implements ISystemFactory{
    @Override
    public IInterfaceController createInterfaceController() {
        return new IOSInterfaceController();
    }

    @Override
    public IOperationController createOperationController() {
        return new IOSOperationController();
    }
}
