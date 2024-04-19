package designpatterns.factorymethod;

public class GifPic implements IPic{

    @Override
    public void readPic() {
        System.out.println("gif read success");
    }
}
