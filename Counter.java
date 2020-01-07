public class Counter{
    //private int count; returns 1 1 when ran. 
    //static variables are shared between all objects
    private static int count;

    public Counter(){
        count += 1;
    }

    public void print() {
        System.out.print(count);
    }
}