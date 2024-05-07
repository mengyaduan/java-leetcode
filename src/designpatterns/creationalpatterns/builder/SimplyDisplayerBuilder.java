package designpatterns.creationalpatterns.builder;

public class SimplyDisplayerBuilder extends DisplayerBuilder {
    @Override
    public void buildMenu() {

    }

    @Override
    public void buildPlayList() {

    }

    @Override
    public void buildMainWindow() {
        displayer.setMainWindow("simply mw");
    }

    @Override
    public void buildControllerBar() {
        displayer.setControllerBar("simply cb");
    }

    @Override
    public void buildFavoriteList() {

    }
}
