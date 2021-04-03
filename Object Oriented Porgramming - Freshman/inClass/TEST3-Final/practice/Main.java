import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Circle C = new Circle();
        Square SQ = new Square();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number of sides");
        int numsides = sc.nextInt();

        if (numsides == 0){
            C.print();
        }
        else if(numsides == 4){
            SQ.print();
        }
        else {
            System.out.println("N/A");
        }
    }
}