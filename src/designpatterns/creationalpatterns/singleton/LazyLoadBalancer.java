package designpatterns.creationalpatterns.singleton;

/**
 * 带有双重检验的懒汉单例模式
 */
public class LazyLoadBalancer {
    private static volatile LazyLoadBalancer lazyLoadBalancer;

    private LazyLoadBalancer() {
    }

    public static LazyLoadBalancer getInstance() {
        if (lazyLoadBalancer == null) {
            synchronized (LazyLoadBalancer.class) {
                if (lazyLoadBalancer == null) {
                    lazyLoadBalancer = new LazyLoadBalancer();
                }
            }
        }
        return lazyLoadBalancer;
    }
}
