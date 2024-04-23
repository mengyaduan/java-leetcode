package designpatterns.simplefactory;

public class ShapeFactory {
    public static IShape createShape(String type) {
        switch (type) {
            case "circle":
                return new CircleShape();
            case "rectangle":
                return new RectangleShape();
            default:
                System.out.println("UnSupportedShapeException");
                return null;
        }
    }

}
