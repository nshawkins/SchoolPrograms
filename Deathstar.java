import java.util.Scanner;

public class Deathstar{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        int [] ans = new int[n];
        int [][] arr = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++){
            count = 0;
            for (int j = 0; j < n; j++){
                count = (count | arr[i][j]);
            }
            ans[i] = count;
        }
        for (int i = 0; i < n; i++){
            System.out.print(ans[i] + " ");
        }
        sc.close();
    }
}