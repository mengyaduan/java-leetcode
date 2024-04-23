package designpatterns.abstractfactory;

import designpatterns.XMLUtil;

public class Client {
    public static void main(String[] args) {
        ISystemFactory factory;
        IOperationController operationController;
        IInterfaceController interfaceController;

        factory = (ISystemFactory) XMLUtil.getBean("className");
        operationController = factory.createOperationController();
        interfaceController = factory.createInterfaceController();

        operationController.showOperation();
        interfaceController.showInterface();
    }
}
