package designpatterns.creationalpatterns.factorymethod;

public class JpegFactory implements IPicFactory {
    @Override
    public IPic createPic() {
        return new JpegPic();
    }
}
