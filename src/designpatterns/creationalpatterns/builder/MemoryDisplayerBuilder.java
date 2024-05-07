package designpatterns.creationalpatterns.builder;

public class MemoryDisplayerBuilder extends DisplayerBuilder {
    @Override
    public void buildMenu() {
        displayer.setMenu("memory menu");
    }

    @Override
    public void buildPlayList() {

    }

    @Override
    public void buildMainWindow() {

    }

    @Override
    public void buildControllerBar() {
        displayer.setControllerBar("memory cb");
    }

    @Override
    public void buildFavoriteList() {
        displayer.setFavoriteList("memory fl");
    }
}
