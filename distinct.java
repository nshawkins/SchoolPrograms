import java.util.Scanner;

public class distinct{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    //create original array of size 100
    int [] orig = new int[100];

    //Step 1: Read input as long as it isnt -1
    // -store each element in the array
    // -increment total by 1
    int value = sc.nextInt();
    int total = 0;
    while (value != -1){
      orig[total] = value;
      total += 1;
      value = sc.nextInt();
    }
    // step 2: copy all elements in orig into copyArray (skip duplicates)

    int [] copyArray = new int[100];
    int count = 0;
    for (int i = 0; i < total; i++) {
      // check if element orig[i] is already within copyArray
      boolean found = false;
      for (int j = 0; j < count; j++){
        if (orig[i] == copyArray[j]){
          found = true;
          break;
        }
      }
      if (!found) {
        copyArray[count] = orig[i];
        count += 1;
      }
    }
    // step 3: print unique elements
    System.out.print("(");
    for (int i = 0; i < count; i++){
      System.out.printf("%3d,", copyArray[i]);
    }
    System.out.print("\b)");
  }
}
