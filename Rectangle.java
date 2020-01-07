public class Rectangle extends Polygon {
    protected double width; //encapsulations
    protected double height;

    //constructor 

    public Rectangle(){

    }
    //constructors carry over from parent to child
    //create blank constructors 
    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
        this.area = width * height;
        sides = 4;
    }

    public double computeArea(){
        return width * height;
    }
}