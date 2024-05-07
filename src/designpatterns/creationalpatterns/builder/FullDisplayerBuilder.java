package designpatterns.creationalpatterns.builder;

public class FullDisplayerBuilder extends DisplayerBuilder {

    @Override
    public void buildMenu() {
        displayer.setMenu("full menu");
    }

    @Override
    public void buildPlayList() {
        displayer.setPlayList("full pl");
    }

    @Override
    public void buildMainWindow() {
        displayer.setMainWindow("full mw");
    }

    @Override
    public void buildControllerBar() {
        displayer.setControllerBar("full cb");
    }

    @Override
    public void buildFavoriteList() {
        displayer.setFavoriteList("full fl");
    }
}
