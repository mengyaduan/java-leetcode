package designpatterns.creationalpatterns.portotype;

import java.io.Serializable;

public class Address implements Serializable {
    String addr;

    Address(String addr) {
        this.addr = addr;
    }

    public void showAddr() {
        System.out.println(this.addr);
    }
}
