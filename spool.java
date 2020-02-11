import java.lang.Math;
import java.util.Scanner;

public class spool{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int spools = 0;
        float length = 0;
        float tmp = 0;
        int [] num = new int[n];
        for (int i = 0; i < n; i++){
            spools = sc.nextInt();
            length = sc.nextFloat();
            tmp = (int)(500f/length);
            num[i] = (int)(Math.ceil(spools/tmp));
        }
        for (int i = 0; i < n; i++){
            System.out.println(num[i]);
        }
        sc.close();
    }
}