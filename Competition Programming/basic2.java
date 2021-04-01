import java.util.Scanner;
import java.util.Arrays;

public class basic2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int key = 0; boolean YorN = false; int BSindex = 0; int count = 0;
        int arr[] = new int[n];
        int tmparr[] = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        //--------------------------------------
        // test 1
        if (t == 1){
            for (int i = 0; i < n; i++){
                key = 7777 - arr[i];
                BSindex = Arrays.binarySearch(arr, key);
                if (BSindex >= 0){
                    YorN = true;
                }
            }
            if (YorN == true){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
        //---------------------------------------
        // test 2
        if (t == 2){
            tmparr = Arrays.copyOf(arr, n);
            for (int i = 0; i < n; i++){
                key = arr[i];
                tmparr[i] = -1;
                BSindex = Arrays.binarySearch(tmparr, key);
                if (BSindex >= 0){
                    YorN = true;
                }
            }
            if (YorN == false){
                System.out.println("Unique");
            }else {
                System.out.println("Contains Duplicate");
            }
        }
        //---------------------------------------
        // test 3
        if (t == 3){
            try{
            for(int i = 0; i < n; i++) {
                int value = arr[i];
                tmparr[value]++;
            }
        
            // now find the index of the largest tally - this is the mode
            int maxIndex = 0;
            for(int i = 1; i < n; i++) {
                if(tmparr[i] > tmparr[maxIndex]) {
                    maxIndex = i;
                }
            }
            for (int i = 0; i < n; i++){
                if (arr[i] == maxIndex){
                    count++;
                }
            }
            if (count > (n/2)){
                System.out.println(maxIndex);
            } else{
                System.out.println("-1");
            }

            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("-1");
            } 
        }
        //---------------------------------------
        // test 4
        if (t == 4){
            if (n % 2 == 0){
                System.out.println(arr[(n/2) - 1] + " " +  arr[n/2]); 
            }else{
                System.out.println(arr[n/2]);
            }
        }
        //---------------------------------------
        // test 5
        if (t == 5){
            for (int i = 0; i < n; i++){
                if ((arr[i] >= 100) && (arr[i] < 1000)){
                    tmparr[i] = arr[i];
                }
            }
            Arrays.sort(tmparr);
            for (int i = 0; i < n; i++){
                if (tmparr[i] != 0){
                    System.out.print(tmparr[i] + " ");
                }
            }
        }
        //---------------------------------------
        sc.close();
    }
}