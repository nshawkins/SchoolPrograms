import java.util.Scanner;

public class bits{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int num = 0; int tmp = 0;
        int count = 0; int count2 = 0;
        String size = "";
        int [] arr = new int[n];
        for (int i = 0; i < n; i++){
            num = sc.nextInt();
            tmp = num;
            size = Integer.toString(num);
            for (int j = 0; j < size.length(); j++){
                while (tmp > 0){
                    if ((tmp & 1) != 0){
                        count++;
                    }
                    tmp >>= 1; 
                }
                num /= 10;
                tmp = num;
                if (count2 < count){
                    count2 = count;
                }
                count = 0;
            }
            arr[i] = count2;
            count = 0;
            count2 = 0;
        }
        for (int i = 0; i < n; i++){
            System.out.println(arr[i]);
        }
        sc.close();
    }
}