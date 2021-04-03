import java.util.Scanner;
public class PrintTable{
  public static void main(String[] args){
    final int SIZE = 3;
    int [][] table = new int[3][3];

    Scanner sc = new Scanner(System.in);

for (int i = 0; i < SIZE; i++){
  for (int j = 0; j < SIZE; j++) {
    table[i][j] = sc.nextInt();
  }
}

  // print the diagonal
  for (int i = 0; i < SIZE; i++){
    System.out.printLn(table[i][i]);
  }

  // print n-sum of table (shape of n on table (left column + diagonal + right column))
  for (int i = 0; i < SIZE; i++){
    int t = table[i][0];
  }
  }
}
