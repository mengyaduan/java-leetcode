package designpatterns.creationalpatterns.builder;

public class Client {
    public static void main(String[] args) {

        DisplayerBuilder builder = new FullDisplayerBuilder();
        Director director = new Director();
        Displayer displayer = director.construct(builder);
        System.out.println(displayer.toString());


        DisplayerBuilder builder1 = new MemoryDisplayerBuilder();
        System.out.println(director.construct(builder1));


        DisplayerBuilder builder2 = new SimplyDisplayerBuilder();
        System.out.println(builder2.constructWithoutDirector());
    }
}
