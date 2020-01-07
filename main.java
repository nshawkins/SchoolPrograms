public class main{
    public static void main(String[] args){
        Date today = new Date(2, 27, 2019); // 02/27/2019
        today.print();

        Student Tom = new Student();
        Tom.DOB = new Date(01, 01, 2001);
        Tom.setName = "Tom Q.";
        Tom.GPA = 4.0;
        Tom.classification = "JR";
        Tom.LUID = "L1234567";
    }
}