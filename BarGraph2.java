import java.util.Scanner;

public class BarGraph2{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("Number of values to graph: ");
    int value = sc.nextInt();
    int[] array = new int[value];
    System.out.print("Enter the integer values seperated by a space: ");
    for (int i = 0; i < value; i++){
      array[i] = sc.nextInt();
    }
    int[] unique = new int [value];
    int[] frequency = new int[value];
    for (int i = 0; i < value; i++){
      unique[i] = -1;
    }
    for(int i = 0; i < value; i++){
      for (int j = 0; j < value; j++){
        if(array[i] == unique[j]){
          frequency[j]++;
          break;
        }
        else if (unique[j] == -1){
          unique[j] = array[i];
          frequency[j]++;
          break;
        }
      }
    }
    System.out.print("Bar graph for ");
    for (int i = 0; i < unique.length; i++){
      if (unique[i] != -1){
        System.out.print(" " + unique[i]);
      }
    }
    System.out.println(":");
    int max = 0;
    for(int i = 0; i < value; i++){
      if (frequency[i] > max){
        max = frequency[i];
      }
    }
    int var = max;
    for (int i = 0; i < max; i++){
      for (int j = 0; j < unique.length; j++){
        if (unique[j] != -1){
          if (frequency[j] >= var){
            System.out.print(" ######");
          }
          else {
            System.out.print("       ");
          }
        }
      }
      System.out.println();
      var--;
    }
    for (int i = 0; i < array.length; i++){
      if (unique[i] != -1){
        System.out.print("-------");
      }
    }
    System.out.println();
    for (int i = 0; i <= unique.length - 1; i++){
      if (unique[i] != -1){
        System.out.printf("%7d", unique[i]);
      }
    }
    System.out.println();
    for (int i = 0; i < unique.length; i++){
      if (unique[i] != -1){
        System.out.printf("%6.1f", ((float)frequency[i]/value)*100);
        System.out.print("%");
      }
    }
  }
}
