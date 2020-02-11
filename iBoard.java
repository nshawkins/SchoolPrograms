import java.util.Scanner;

public class iBoard{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = ""; String result = "";
        int ones = 0; int zeroes = 0;
        while (sc.hasNextLine()){ //!= eof
            input = sc.nextLine(); //getline
            char[] charr = input.toCharArray();
            for (int i = 0; i < charr.length; i++){
                result += Integer.toBinaryString(charr[i]) + " ";
            }
            int i;
            for (i = 0; i < result.length(); i++){
                if(Character.toString(result.charAt(i)).equals("1")){
                    ones++;
                } 
                // else if(Character.toString(result.charAt(i)).equals("0")){
                    // zeroes++;
                // }
                // zeroes += (7 - i);
            }
            zeroes = (input.length() * 7 )- ones;
            if (((zeroes % 2) == 0) && ((ones % 2) == 0)){
                System.out.println("free");
            }else{
                System.out.println("trapped");
            }
            ones = 0;
            zeroes = 0;
            result = "";
        }
        sc.close();
    }
}