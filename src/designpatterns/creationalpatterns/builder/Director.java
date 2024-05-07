package designpatterns.creationalpatterns.builder;

public class Director {

    public Displayer construct(DisplayerBuilder displayerBuilder) {
        displayerBuilder.buildMenu();
        displayerBuilder.buildControllerBar();
        displayerBuilder.buildFavoriteList();
        displayerBuilder.buildMainWindow();
        displayerBuilder.buildPlayList();
        return displayerBuilder.createDisplayer();
    }

}
