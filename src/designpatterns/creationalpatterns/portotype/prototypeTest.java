package designpatterns.creationalpatterns.portotype;

import org.testng.annotations.Test;

public class prototypeTest {
    @Test(description = "")
    public void test() throws Exception {
        Customer customer1 = new Customer("abc", "213");

        Customer customer2 = customer1.commonCopy();
        Customer customer3 = customer1.javaCopy();
        Customer customer4 = customer1.deepCopy();

        System.out.println("commonCopy");
        System.out.println(customer1 == customer2);
        System.out.println(customer1.getAddress() == customer2.getAddress());

        System.out.println("javaCopy");
        System.out.println(customer1 == customer3);
        System.out.println(customer1.getAddress() == customer3.getAddress());

        System.out.println("deepCopy");
        System.out.println(customer1 == customer4);
        System.out.println(customer1.getAddress() == customer4.getAddress());
    }
}
