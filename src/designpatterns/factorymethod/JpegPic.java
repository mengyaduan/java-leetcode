package designpatterns.factorymethod;

public class JpegPic implements IPic{

    @Override
    public void readPic() {
        System.out.println("jpeg read success");
    }
}
