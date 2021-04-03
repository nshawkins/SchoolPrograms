import java.util.Scanner;

public class Flip{
  public static void main(String[] args){
    String sentence = "";
    Scanner sc = new Scanner(System.in);
    if(sentence.length() <= 80){
      while (!(sentence.equals("STOP"))){
        char[] characters = sentence.toCharArray();
        for (int i = 0; i < sentence.length(); i++){
          char c = characters[i];
          if (Character.isUpperCase(c)){
            characters[i] = Character.toLowerCase(c);
          }
          else if (Character.isLowerCase(c)){
            characters[i] = Character.toUpperCase(c);
          }
        }
        System.out.println(characters);
        sentence = sc.nextLine();
    }
    }

  }
}
