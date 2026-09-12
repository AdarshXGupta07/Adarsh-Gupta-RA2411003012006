public class RectangleSquareDemo {

    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.setWidth(10);
        r.setHeight(20);
        System.out.println("Rectangle area: " + r.getArea());

        Rectangle sq = new Square();
        sq.setWidth(10);
        sq.setHeight(20);
        System.out.println("Expected 200 but got " + sq.getArea());
    }
}
