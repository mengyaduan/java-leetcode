package designpatterns.simplefactory;

public class RectangleShape implements IShape{
    @Override
    public void draw() {
        System.out.println("draw a rectangle");
    }

    @Override
    public void erase() {
        System.out.println("erase a rectangle");
    }
}
