public class RectangleSquareDemo {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setHeight(20);
        System.out.println("Plain rectangle area: " + rectangle.getArea());

        Rectangle shape = new Square();
        shape.setWidth(10);
        shape.setHeight(20);
        System.out.println("Expected area: 200");
        System.out.println("Actual area: " + shape.getArea());
    }
}
