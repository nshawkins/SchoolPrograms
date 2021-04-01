//CBA, greatest least middle
//BCA, middle greatest least
//take inputs into an array and sort
//take char values in and then -65. int array at char1 then 2 then 3
import java.util.Scanner;
import java.util.Arrays;
public class ABC{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num1, num2, num3;
        String alpha;
        char cha1, cha2, cha3;
        num1 = sc.nextInt(); num2 = sc.nextInt(); num3 = sc.nextInt();
        int [] arr1 = new int[3];
        arr1[0] = num1; arr1[1] = num2; arr1[2] = num3;
        Arrays.sort(arr1);
        alpha = sc.next();
        cha1 = alpha.charAt(0); cha2 = alpha.charAt(1); cha3 = alpha.charAt(2);
        cha1 -= 65; cha2 -= 65; cha3 -= 65;
        System.out.println(arr1[cha1]+ " " + arr1[cha2] + " " + arr1[cha3]);

        sc.close();
    }
}