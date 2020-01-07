import java.util.Scanner;

public class BarGraph{
  public static void main (String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Number of values to graph: ");
    int num = sc.nextInt(); //takes inputs
    int[] array = new int[num]; //puts inputs into array
    int max = 0; //holder for maximum digit

    if (num != 0){  //sets height for entire graph
      for (int i = 0; i < num; i++){
        array[i] = sc.nextInt();
        if (array[i] > max){
          max = array[i];
        }
      }
      System.out.print("Bar graph for");
      for (int i = 0; i < num; i++){
        System.out.print(" "+ array[i]); //take inputs and turn into string for print
      }
      System.out.println(":"); //part of print
      int var = max;

      //for loop for the vertical ammount
      for ( int i = 0; i < max; i++){
        for (int j = 0; j < array.length; j++){
          System.out.print("  ");
          if(array[j] >= var){
            System.out.print("#");
          }
          else{
            System.out.print(" ");
          }
        }
        //line ends. move to new row and decrement
        System.out.println();
        var--;
      }
      for (int i = 0; i < array.length; i++){
        System.out.print("---");
      }
      System.out.println();
      for(int i = 0; i <= array.length - 1; i++){
        System.out.printf("%3d", array[i]);
      }
    }
  }
}
