import java.util.Scanner;

public class containers{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = 0;
        String line;
        int fiveGal = 5;
        int threeGal = 3;
        n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++){
            line = sc.nextLine();
            String [] arr = line.split(" ");
            for (int j = 0; j < arr.length; j++){
                if (arr[j].length() == 5){

                }else if(arr[j].length() == 3){
                    if (arr[j].charAt(0) == "-"){

                    } else{

                    }
                }else if(arr[j].length() == 2){
                    
                }
            }
        }

        sc.close();
    }
}