import java.util.Scanner;

public class mean{
  public static double mean(double[] array){
    double sum = 0;
    double num = 0;
    for (int i = 0; i < array.length; i++){
      num = num + array[i];
      sum = num / array.length;
    }
    return sum;
  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    //step 1: read and store elements in array
    System.out.print("What is the size of the array? ");
    int size = sc.nextInt();
    double [] array = new double[size];
    for (int i = 0; i < size; i++){
      array[i] = sc.nextDouble();

      //step 2: call mean(...) function to compute average of elements

      //step 3: print value
    }
    double avg = mean(array);
    System.out.printf("The average of these %d numbers is %.2f.", size, avg);
  }
}
