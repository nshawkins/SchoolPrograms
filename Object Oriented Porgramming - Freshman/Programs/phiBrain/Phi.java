import java.util.Scanner;
import java.util.ArrayList;

public class Phi{
public static int phi (int n) {
    int result = n;
    for (int i=2; i*i<=n; ++i)
        if (n % i == 0) {
            while (n % i == 0)
                n /= i;
            result -= result / i;
        }
    if (n > 1)
        result -= result / n;
    return result;
}

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer n: ");
        int i = sc.nextInt();
        System.out.println("Phi(n): " + phi(i));
    }
}