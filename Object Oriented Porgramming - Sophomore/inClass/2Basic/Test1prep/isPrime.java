import java.util.Scanner;

public class Example6{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the maximum number: ");
    int max = sc.nextInt();

    for (int i = 2; i <= max; i++) {
      //if i is prime, print if
      boolean isPrime = true;
      for (int j = 2; j < i; j++){
        if (i%j == 0){
          isPrime = false;
          break;
        }
      }

      if (isPrime)
        System.out.print(" " + i);
    }
  }
}
