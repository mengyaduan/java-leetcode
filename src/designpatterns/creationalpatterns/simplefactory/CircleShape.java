package designpatterns.simplefactory;

public class CircleShape implements IShape{
    @Override
    public void draw() {
        System.out.println("draw a circle");
    }

    @Override
    public void erase() {
        System.out.println("erase a circle");
    }
}
