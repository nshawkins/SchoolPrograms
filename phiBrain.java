import java.util.Scanner;
import java.util.ArrayList;

public class phiBrain{
    public int phi(int n){
        int val = 0;
        int count = 0;

        for (int j = 0; j < 250000; j++){
            while (j < n){
                if (n % 2 == 0 && n % 5 == 0){
                    val = ;
                }
                else {
                    continue;
                }
            count++;
            }
        }

        return count;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a positive integer n: ");
        int i = sc.nextInt();
        i.phi;
        System.out.println("Phi(n): ");
    }
}