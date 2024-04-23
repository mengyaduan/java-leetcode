package designpatterns.singleton;

public class IoDHLoadBalancer {

    private IoDHLoadBalancer(){

    }

    private static class HolderClass{
        private final static IoDHLoadBalancer  ioDHLoadBalancer = new IoDHLoadBalancer();
    }


    public static IoDHLoadBalancer getInstance(){
        return HolderClass.ioDHLoadBalancer;
    }


}
