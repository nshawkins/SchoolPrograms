public class main{
    public static void main(String[] args){
        Counter C = new Counter();
        C.print(); //if count is not static, count C is seperate from count D
    

        Counter D = new Counter ();
        D.print(); //if count is static, count D is NOT seperate from count C
        //C.print() would cause 1 2 to be printed regardless of it being static or not (excluding line 4)
    }
}