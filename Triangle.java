public class Triangle extends Polygon{
    protected double base;
    protected double height;

    public Triangle(double base, double height){
        this.base = base;
        this.height = height;
        sides = 3;
        area = 0.5 * base * height;
    }
}