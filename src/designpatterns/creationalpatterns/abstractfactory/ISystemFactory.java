package designpatterns.abstractfactory;

public interface ISystemFactory {
    IInterfaceController createInterfaceController();
    IOperationController createOperationController();
}
