package designpatterns.portotype;

import lombok.Data;

import java.io.*;

@Data
public class Customer implements Cloneable, Serializable{
    String name;
    Address address;

    Customer(String name, String addr) {
        this.name = name;
        address = new Address(addr);
    }

    /**
     * 通用clone方法：深拷贝
     */
    public Customer commonCopy() {
        return new Customer(this.name, this.address.addr);
    }

    /**
     * java提供的clone()方法：浅拷贝
     *
     * @return
     */
    public Customer javaCopy() {
        Object object = null;
        try {
            object = super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Not support cloneable");
        }
        return (Customer) object;
    }

    public Customer deepCopy() throws Exception {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(this);

        ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (Customer) ois.readObject();


    }

}
