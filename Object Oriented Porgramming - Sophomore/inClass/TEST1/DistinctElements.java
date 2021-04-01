import java.util.Scanner;

public class DistinctElements{

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter integer values into the array, or -1 to stop:");
    int[] array = new int[100];
    for (int i = 0; i < array.length; i++){
      array[i] = sc.nextInt();
      if (array[i] == -1)
        break;
    }
    System.out.println("Distinct values in the array:");
    System.out.printf("()"); //()"(%2d)", array[i]) err array[i] scope = for loop
  }
}
/* TO DO:
  create only distinct elements for array
  print distinct elements
  put 'num' input into array
  array[i] - 1 to remove '-1' from array
  runtime error in final printf statement if using array[i]
  */
