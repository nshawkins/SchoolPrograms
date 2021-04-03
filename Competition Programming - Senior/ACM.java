/*while read int != sentinel read rest of line */
import java.util.Scanner;
public class ACM{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = 100;
        int count = 0;
        String right;
        int temp = 0;
        int [] numbers = new int[size];
        String [] characters = new String[size];
        int [] words = new int[size];
        int i = 0;
        int input = sc.nextInt();
        while (input != -1){
            numbers[i] = input;
            characters[i] = sc.next();
            right = sc.next();
            if (right.equals("right")){
                words[i] = 1;
            } else{
                words[i] = 0;
            }
            i++;
            input = sc.nextInt();
        }
        for (int j = 0; j < i; j++){
            if (numbers[j] <= 300){
                if(words[j] == 1){
                    temp += numbers[j];
                    count += 1;
                    for (int k = 0; k < j; k++){
                        if (characters[j].equals(characters[k])){
                            temp += 20;
                        }
                    }
                }
            }
        }
        System.out.println(count + " " + temp);
        sc.close();
    }
}