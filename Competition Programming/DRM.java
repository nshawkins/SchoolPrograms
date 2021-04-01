import java.util.Scanner;

public class DRM{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str1, str2, str3;
        int len, half, tmp1, tmp2;
        int count1 = 0; int count2 = 0; int temp = 0; int temp2 = 0;
        str1 = sc.next();
        len = str1.length();
        //divide
        half = len/2;
        str2 = str1.substring(0, half);
        StringBuilder string2 = new StringBuilder(str2);
        str3 = str1.substring(half, str1.length());
        StringBuilder string3 = new StringBuilder(str3);
        StringBuilder string4 = new StringBuilder(str3);
        //rotate number
        for (int i = 0; i < str2.length(); i++){
            count1 += str2.charAt(i);
            count1 -= 65;
        }
        for (int i = 0; i < str3.length(); i++){
            count2 += str3.charAt(i);
            count2 -= 65;
        }
        //rotation
        for (int i = 0; i < str2.length(); i++){
            tmp1 = str2.charAt(i);
            tmp1 += count1;
            for (int j = tmp1-count1, k = tmp1-count1; j <= tmp1; j++, k++){
                if (k > 90){
                    k = 65;
                }
                temp = k;
            }
            tmp1 = temp;
            string2.setCharAt(i, (char)tmp1);
        }
        for (int i = 0; i < str3.length(); i++){
            tmp2 = str3.charAt(i);
            tmp2 += count2;
            for (int j = tmp2-count2, k = tmp2-count2; j <= tmp2; j++, k++){
                if (k > 90){
                    k = 65;
                }
                temp = k;
            }
            tmp2 = temp;
            string3.setCharAt(i, (char)tmp2);
        }
        //merge
        for (int i = 0; i < str2.length(); i++){
            tmp1 = string2.charAt(i);
            tmp2 = string3.charAt(i);
            temp = tmp1 + (tmp2 - 65);
            for (int j = tmp1, k = tmp1; j <= temp; j++, k++){
                if (k > 90){
                    k = 65;
                }
                temp2 = k;
            }
            string4.setCharAt(i, (char)temp2);
        }
        System.out.println(string4);
        sc.close();
    }
}