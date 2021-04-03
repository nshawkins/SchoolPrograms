import java.util.Scanner;

public class jaggedArray{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.print("how many rows are in the jagged array? ");
    //integer.parseint consumes the \n
    int rows = sc.nextInt();
    int [][] array = new int[rows][];
    //another way to consime the extra \n
    String junk = sc.nextLine();

    // read elements from each rows
    for (int i = 0; i < rows; i++){
      System.out.print("Enter a row, seperated by spaces: ");
      String line = sc.nextLine();

      // split string by spaces
      String[] tokens = line.split("\\s+"); //use regex?
      array[i] = new int[tokens.length];
      for (int j = 0; j < tokens.length; j++){
        array[i][j] = Integer.parseInt(tokens[j]); // converting string to int
      }
    }
    System.out.println("After the funky operation, the resulting operation is: ");
    // printing contense or JaggedArray
    for (int i = 0; i < array.length; i++){
      for (int j = 0; j < array[i].length; j++){
        System.out.printf("%5d", array[i][j] * (i*j*1));
      }
      System.out.println();
    }
  }
}
