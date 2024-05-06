package designpatterns.creationalpatterns.factorymethod;

public class GifFactory implements IPicFactory{
    @Override
    public IPic createPic() {
        return new GifPic();
    }
}
