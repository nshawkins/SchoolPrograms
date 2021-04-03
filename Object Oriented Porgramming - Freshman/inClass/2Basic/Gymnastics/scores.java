import java.util.Scanner;

public class scores{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    double max = 0;
    double min = 0;
    double total = 0;
    double [] array = new double[7];

    for (int i = 0; i < array.length; i++){
      array[i] = sc.nextInt();
      total = total + array[i];
      max = array[0];
      min = array[0];
      if (max < array[i]){
        max = array[i];
      }
      else if (min < array[i]){
        min = array[i];
      }
    }
    total = total - max - min;
    double avg = total / array.length - 2;

    System.out.print("Average score: " + avg);
  }
}
