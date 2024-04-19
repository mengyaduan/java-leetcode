package designpatterns.factorymethod;

import org.testng.annotations.Test;

public class fmTest {

    @Test(description = "")
    public void test() throws Exception {
        IPicFactory factory;
        factory = new JpegFactory();
        IPic myPic = factory.createPic();
        myPic.readPic();
    }
}
