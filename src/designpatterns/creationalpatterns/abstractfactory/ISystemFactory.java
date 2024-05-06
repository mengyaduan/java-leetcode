package designpatterns.creationalpatterns.abstractfactory;

public interface ISystemFactory {
    IInterfaceController createInterfaceController();
    IOperationController createOperationController();
}
