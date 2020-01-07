public class Square extends Rectangle{
    public Square(double width){
        super(width, width); // calls parent function -- rectangle(width, width);

        //OR
        //height = w;
        //width = w;
        //super(w, w); calls Rectangle(w, w);
        //this class cannot access computeArea in polygon because it has been overriden
    }
}