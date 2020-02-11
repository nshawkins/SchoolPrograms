/*for loop for checking min input to max input and only incrementing
when a number is in the string inputs

store first inputs in one array and second inputs in another array

if a number is between a left right pair ar1[0] and ar2[0] then it should be counted*/

import java.util.Scanner;
import java.util.*;
public class FreeFood{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size, min, max;
        size = sc.nextInt();
        int [] arr1 = new int[size];
        int [] arr2 = new int[size];
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i = 0; i < size; i++){
            arr1[i] = sc.nextInt();
            arr2[i] = sc.nextInt();
        }
        for(int i = 0; i < size; i++){
            min = arr1[i];
            max = arr2[i];
            for (int j = min; j <= max; j++){
                if (!list.contains(j)){
                    list.add(j);
                }
            }
        }
        System.out.println(list.size());
        sc.close();
    }
}