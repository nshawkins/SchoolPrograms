import java.util.Scanner;
import java.util.*;

public class jumbled{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int input = 0; int tmp = 0; String bin = ""; 
        int [] ans = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < n; i++){
            input = sc.nextInt();
            bin = Integer.toBinaryString(input);
            tmp = (input & 1);
            stack.push(tmp);
            input >>= 1;
            for (int j = 0; j < 7; j++){
                stack.push(stack.peek() ^ (input & 1));
                input >>= 1;
            }
            String str = "";
            for (int j = 0; j < 8; j++){
                str += stack.pop();
            }
            tmp = Integer.parseInt(str, 2);
            ans[i] = tmp;
            stack.clear();
        }
        for(int i = 0; i < n; i++){
            System.out.print(ans[i] + " ");
        }
        sc.close();
    }
}