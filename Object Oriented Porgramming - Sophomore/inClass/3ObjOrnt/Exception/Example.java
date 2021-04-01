import java.util.Scanner;

public class Example {
    public static void main(String[] args){
        System.out.print("Enter a number:");
        Scanner sc = new Scanner(System.in);

        int inverse = 0;
        try {
            inverse = 10 / sc.nextInt();
            System.out.println("The inverse of the number is:" + inverse);
        }
        catch(ArithmeticException ex) {
            System.out.println("Sorry! Could not compute.");
            System.out.println(ex.toString());
            System.exit(-1);
        }
        sc.close();
    }
}