package designpatterns.creationalpatterns.builder;

public abstract class DisplayerBuilder {
    protected Displayer displayer = new Displayer();

    public abstract void buildMenu();

    public abstract void buildPlayList();

    public abstract void buildMainWindow();

    public abstract void buildControllerBar();

    public abstract void buildFavoriteList();

    public Displayer createDisplayer() {
        return displayer;
    }

    public Displayer constructWithoutDirector() {
        this.buildMenu();
        this.buildControllerBar();
        this.buildPlayList();
        this.buildFavoriteList();
        this.buildMainWindow();
        return displayer;
    }


}
