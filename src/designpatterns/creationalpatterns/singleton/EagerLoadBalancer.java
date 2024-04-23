package designpatterns.singleton;

/**
 * 饿汉式单例模式
 **/
public class EagerLoadBalancer {
    private static final EagerLoadBalancer eagerLoadBalancer = new EagerLoadBalancer();

    private EagerLoadBalancer() {
    }

    public static EagerLoadBalancer getInstance() {
        return eagerLoadBalancer;
    }

}
